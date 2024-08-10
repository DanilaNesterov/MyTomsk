package com.example.mytomsk.data

import androidx.annotation.DrawableRes

data class Recommendation(
    val title: String,
    @DrawableRes val image: Int,
    val description: String,
    val category: CategoryType
)
