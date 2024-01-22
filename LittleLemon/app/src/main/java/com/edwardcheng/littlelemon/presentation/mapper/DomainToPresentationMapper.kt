package com.edwardcheng.littlelemon.presentation.mapper

import com.edwardcheng.littlelemon.domain.entity.MenuEntity
import com.edwardcheng.littlelemon.domain.entity.UserEntity
import com.edwardcheng.littlelemon.presentation.model.InfoData
import com.edwardcheng.littlelemon.presentation.model.MenuItemData

fun List<MenuEntity>.toPresentation() =
    map { it.toPresentation() }

private fun MenuEntity.toPresentation() =
    MenuItemData(
        title = title,
        description = description,
        price = "$${String.format("%.2f", price)}",
        category = category,
        image = image,
    )


fun UserEntity.toPresentation(): List<InfoData> {
    return listOf(
        InfoData(
            label = "First Name",
            value = firstName
        ),
        InfoData(
            label = "Last Name",
            value = lastName
        ),
        InfoData(
            label = "Email",
            value = email
        ),
    )
}
