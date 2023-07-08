package com.nameisjayant.projects.furniture.data

import androidx.annotation.DrawableRes
import com.nameisjayant.chatapp.R

data class PopularProducts(
    val id: Int,
    val title: String,
    @DrawableRes val image: Int,
    val price: String
)

val popularProductList = listOf(
    PopularProducts(
        1,
        "Sverom chair",
        R.drawable.product_one,
        "$400"
    ),
    PopularProducts(
        2,
        "Norrviken chair and table",
        R.drawable.product_two,
        "$999"
    ),
    PopularProducts(
        3,
        "Ektorp sofa",
        R.drawable.product_three,
        "$800"
    ),
    PopularProducts(
        4,
        "Jan Sflanaganvik sofa",
        R.drawable.product_four,
        "$700"
    )
)