package com.edwardcheng.littlelemon.domain.entity

data class MenuEntity(
    val title: String,
    val description: String,
    val price: Double,
    val category: String,
    val image: String,
)