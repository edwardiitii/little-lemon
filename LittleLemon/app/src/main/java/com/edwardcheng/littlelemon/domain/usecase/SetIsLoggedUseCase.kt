package com.edwardcheng.littlelemon.domain.usecase

import com.edwardcheng.littlelemon.domain.repository.LittleLemonRepository

class SetIsLoggedUseCase(private val repository: LittleLemonRepository) {

    operator fun invoke(isLogged: Boolean) {
        repository.setIsLogged(isLogged)
    }
}