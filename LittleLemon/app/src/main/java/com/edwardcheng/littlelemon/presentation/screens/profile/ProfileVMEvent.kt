package com.edwardcheng.littlelemon.presentation.screens.profile

sealed class ProfileVMEvent {
    object NavigateBack : ProfileVMEvent()
    object NavigateToLogin : ProfileVMEvent()
}