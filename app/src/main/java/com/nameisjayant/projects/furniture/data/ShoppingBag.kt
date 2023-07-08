package com.nameisjayant.projects.furniture.data

import androidx.annotation.DrawableRes
import com.nameisjayant.chatapp.R


data class ShoppingBag(
    val id: Int,
    @DrawableRes val icon: Int,
    val title: String,
    val qty: Int,
    val price: String
)

val shoppingList = listOf(
    ShoppingBag(
        1,
        R.drawable.product_one,
        "Jan Sflanaganvik sofa",
        1,
        "$566"
    ),
    ShoppingBag(
        2,
        R.drawable.product_two,
        "Sverom chair",
        3,
        "$566"
    ),
    ShoppingBag(
        3,
        R.drawable.product_three,
        "Kallax chair",
        1,
        "$566"
    ),

    )