package com.edwardcheng.littlelemon.domain.repository

import com.edwardcheng.littlelemon.domain.entity.MenuEntity
import com.edwardcheng.littlelemon.domain.entity.UserEntity

interface LittleLemonRepository {

    suspend fun getMenu(): List<MenuEntity>

    fun getIsLogged(): Boolean

    fun setIsLogged(isLogged: Boolean)

    fun getUserData(): UserEntity

    fun setUserData(firstName: String?, lastName: String?, email: String?)
}