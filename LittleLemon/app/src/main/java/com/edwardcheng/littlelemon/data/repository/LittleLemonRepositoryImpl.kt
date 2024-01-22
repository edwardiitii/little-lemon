package com.edwardcheng.littlelemon.data.repository

import android.util.Log
import com.edwardcheng.littlelemon.data.local.datasource.LittleLemonLocalDataSource
import com.edwardcheng.littlelemon.data.mapper.toDomain
import com.edwardcheng.littlelemon.data.mapper.toLocalDataModel
import com.edwardcheng.littlelemon.data.remote.datasource.MenuRemoteDataSource
import com.edwardcheng.littlelemon.domain.entity.MenuEntity
import com.edwardcheng.littlelemon.domain.entity.UserEntity
import com.edwardcheng.littlelemon.domain.repository.LittleLemonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class LittleLemonRepositoryImpl(
    private val remoteDataSource: MenuRemoteDataSource,
    private val localDataSource: LittleLemonLocalDataSource,
    private val ioDispatcher: CoroutineDispatcher,
) : LittleLemonRepository {

    override suspend fun getMenu(): List<MenuEntity> {
        return withContext(ioDispatcher) {
            runCatching {
                remoteDataSource.getMenu()
            }.onFailure {
                Log.e("remoteGetMenu", "error:", it)
            }.onSuccess {
                localDataSource.insertMenu(it.toLocalDataModel())
            }

            localDataSource.getMenu().toDomain()
        }
    }

    override fun getIsLogged(): Boolean {
        return localDataSource.getIsLogged()
    }

    override fun setIsLogged(isLogged: Boolean) {
        localDataSource.setIsLogged(isLogged)
    }

    override fun getUserData(): UserEntity {
        with(localDataSource) {
            return UserEntity(
                firstName = getFirstName(),
                lastName = getLastName(),
                email = getEmail(),
            )
        }
    }

    override fun setUserData(firstName: String?, lastName: String?, email: String?) {
        with(localDataSource) {
            firstName?.let { setFirstName(it) }
            lastName?.let { setLastName(it) }
            email?.let { setEmail(it) }
        }
    }
}