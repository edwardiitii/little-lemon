package com.edwardcheng.littlelemon.domain.usecase

import com.edwardcheng.littlelemon.domain.entity.MenuEntity

class GetCategoriesUseCase {

    operator fun invoke(menuList: List<MenuEntity>): List<String> {
        return menuList.map { it.category }.distinct()
    }
}