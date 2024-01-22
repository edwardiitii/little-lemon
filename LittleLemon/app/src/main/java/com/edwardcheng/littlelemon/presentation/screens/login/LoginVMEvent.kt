package com.edwardcheng.littlelemon.presentation.screens.login

sealed class LoginVMEvent {
    object NavigateToHome : LoginVMEvent()
}