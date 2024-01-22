package com.edwardcheng.littlelemon.data.remote.datasource

import com.edwardcheng.littlelemon.data.remote.model.MenuItemRequest

interface MenuRemoteDataSource {

    suspend fun getMenu(): List<MenuItemRequest>
}