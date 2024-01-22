package com.edwardcheng.littlelemon.domain.usecase

import com.edwardcheng.littlelemon.domain.repository.LittleLemonRepository

class SetUserDataUseCase(private val repository: LittleLemonRepository) {

    operator fun invoke(
        firstName: String? = null, lastName: String? = null, email: String? = null,
    ) {
        repository.setUserData(
            firstName = firstName,
            lastName = lastName,
            email = email
        )
    }
}