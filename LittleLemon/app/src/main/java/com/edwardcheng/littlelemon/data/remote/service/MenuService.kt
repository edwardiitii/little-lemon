package com.edwardcheng.littlelemon.data.remote.service

import com.edwardcheng.littlelemon.data.remote.model.MenuItemRequest

interface MenuService {

    suspend fun getMenu(): List<MenuItemRequest>
}