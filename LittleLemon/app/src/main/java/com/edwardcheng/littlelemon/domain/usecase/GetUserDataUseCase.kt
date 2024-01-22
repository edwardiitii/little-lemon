package com.edwardcheng.littlelemon.domain.usecase

import com.edwardcheng.littlelemon.domain.entity.UserEntity
import com.edwardcheng.littlelemon.domain.repository.LittleLemonRepository

class GetUserDataUseCase(private val repository: LittleLemonRepository) {

    operator fun invoke(): UserEntity {
        return repository.getUserData()
    }
}