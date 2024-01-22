package com.edwardcheng.littlelemon.presentation.navigation

enum class LittleLemonDestination {
    HOME,
    PROFILE,
    LOGIN;

    val route: String
        get() = name.lowercase()
}