package com.edwardcheng.littlelemon.domain.usecase

import com.edwardcheng.littlelemon.domain.repository.LittleLemonRepository

class GetIsLoggedUseCase(private val repository: LittleLemonRepository) {

    operator fun invoke(): Boolean {
        return repository.getIsLogged()
    }
}