package com.example.mytomsk

import com.example.mytomsk.data.CategoryType

sealed class Screen(val route: String) {
    object CategoryList : Screen("categoryList")
    object RecommendationList : Screen("recommendationList/{categoryType}") {
        fun createRoute(categoryType: CategoryType): String = "recommendationList/${categoryType.name}"
    }
    object RecommendationDescription : Screen("recommendationDescription/{title}") {
        fun createRoute(title: String): String = "recommendationDescription/$title"
    }
}