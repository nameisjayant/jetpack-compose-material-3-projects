package com.nameisjayant.projects.furniture.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.nameisjayant.chatapp.R
import com.nameisjayant.projects.ui.theme.CategoryOne
import com.nameisjayant.projects.ui.theme.CategoryTwo

data class Category(
    val id: Int,
    val title: String,
    @DrawableRes val image: Int,
    val color: Color
)

val categoryList = listOf(
    Category(
        1,
        "Chair",
        R.drawable.chair,
        CategoryOne
    ),
    Category(
        2,
        "Sofa",
        R.drawable.sofa,
        CategoryTwo
    ),
    Category(
        3,
        "Desk",
        R.drawable.desk,
        CategoryOne
    ),
    Category(
        4,
        "Bed",
        R.drawable.bed,
        CategoryTwo
    )
)