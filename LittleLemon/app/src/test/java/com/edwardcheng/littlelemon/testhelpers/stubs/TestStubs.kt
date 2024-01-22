package com.edwardcheng.littlelemon.testhelpers.stubs

import com.edwardcheng.littlelemon.data.local.entity.MenuLocalEntity
import com.edwardcheng.littlelemon.data.remote.model.MenuItemRequest
import com.edwardcheng.littlelemon.domain.entity.MenuEntity
import com.edwardcheng.littlelemon.domain.entity.UserEntity
import com.edwardcheng.littlelemon.presentation.model.MenuItemData

fun getRemoteDataMenuList(): List<MenuItemRequest> =
    listOf(
        MenuItemRequest(
            title = "Greek Salad",
            description = "Our delicious salad is served with Feta cheese and peeled cucumber. Includes tomatoes, onions, olives, salt and oregano in the ingredients.",
            image = "imageURL",
            category = "starters",
            price = 12.99,
        ),
        MenuItemRequest(
            title = "Pasta",
            description = "Delicious pasta for your delight.",
            image = "imageURL",
            category = "mains",
            price = 6.99,
        )
    )

fun getLocalDataMenuList(): List<MenuLocalEntity> =
    listOf(
        MenuLocalEntity(
            title = "Greek Salad",
            description = "Our delicious salad is served with Feta cheese and peeled cucumber. Includes tomatoes, onions, olives, salt and oregano in the ingredients.",
            image = "imageURL",
            category = "starters",
            price = 12.99,
        ),
        MenuLocalEntity(
            title = "Pasta",
            description = "Delicious pasta for your delight.",
            image = "imageURL",
            category = "mains",
            price = 6.99,
        )
    )


fun getDomainMenuList(): List<MenuEntity> =
    listOf(
        MenuEntity(
            title = "Greek Salad",
            description = "Our delicious salad is served with Feta cheese and peeled cucumber. Includes tomatoes, onions, olives, salt and oregano in the ingredients.",
            image = "imageURL",
            category = "starters",
            price = 12.99,
        ),
        MenuEntity(
            title = "Pasta",
            description = "Delicious pasta for your delight.",
            image = "imageURL",
            category = "mains",
            price = 6.99,
        )
    )

fun getPresentationMenuList(): List<MenuItemData> = listOf(
    greekSaladItem(),
    MenuItemData(
        title = "Pasta",
        description = "Delicious pasta for your delight.",
        image = "imageURL",
        category = "mains",
        price = "$6.99",
    )
)

fun greekSaladItem() = MenuItemData(
    title = "Greek Salad",
    description = "Our delicious salad is served with Feta cheese and peeled cucumber. Includes tomatoes, onions, olives, salt and oregano in the ingredients.",
    image = "imageURL",
    category = "starters",
    price = "$12.99",
)

fun getCategoryList(): List<String> = listOf("starters", "mains")

fun getUserEntity() = UserEntity(
    firstName = "John",
    lastName = "Doe",
    email = "johndoe@gmail.com"
)