package com.edwardcheng.littlelemon.data.remote.datasource

import com.edwardcheng.littlelemon.data.remote.model.MenuItemRequest
import com.edwardcheng.littlelemon.data.remote.service.MenuService

class MenuRemoteDataSourceImpl(private val service: MenuService): MenuRemoteDataSource {

    override suspend fun getMenu(): List<MenuItemRequest> {
        return service.getMenu()
    }
}