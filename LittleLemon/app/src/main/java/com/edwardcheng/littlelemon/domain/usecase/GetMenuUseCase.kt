package com.edwardcheng.littlelemon.domain.usecase

import com.edwardcheng.littlelemon.domain.entity.MenuEntity
import com.edwardcheng.littlelemon.domain.repository.LittleLemonRepository

class GetMenuUseCase(private val repository: LittleLemonRepository) {

    suspend operator fun invoke(): List<MenuEntity> {
        return repository.getMenu()
    }
}