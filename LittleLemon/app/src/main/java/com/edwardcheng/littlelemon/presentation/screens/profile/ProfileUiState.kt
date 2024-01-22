package com.edwardcheng.littlelemon.presentation.screens.profile

import com.edwardcheng.littlelemon.presentation.model.InfoData

data class ProfileUiState(
    val userInfoList: List<InfoData> = emptyList(),
    val profileEvent: ProfileVMEvent? = null,
)