package com.example.mytomsk

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mytomsk.data.CategoryType

@Composable
fun MyTomskApp(
    navController: NavHostController = rememberNavController(),
    viewModel: MyTomskViewModel = viewModel(),
) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val canNavigateBack = currentBackStackEntry?.destination?.route != Screen.CategoryList.route

    Scaffold(
        topBar = {
            AppBar(
                canNavigateBack = canNavigateBack,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val categories by viewModel.categories.collectAsState()
        val recommendations by viewModel.recommendation.collectAsState()

        NavHost(
            navController = navController,
            startDestination = Screen.CategoryList.route,
            modifier = Modifier.padding(innerPadding)
        ) {

            // Экран с категориями рекомендаций
            composable(Screen.CategoryList.route) {
                CategoryList(
                    categories = categories,
                    onCategoryClick = { categoryType ->
                        navController.navigate(Screen.RecommendationList.createRoute(categoryType))
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }

            // Экран со списком рекомендаций
            composable(
                route = Screen.RecommendationList.route,
                arguments = listOf(navArgument("categoryType") { type = NavType.StringType })
            ) { backStackEntry ->
                val categotyType = CategoryType.valueOf(backStackEntry.arguments?.getString("categoryType") ?: "")
                RecommendationList(
                    categoryType = categotyType,
                    recommendations = recommendations,
                    onRecommendationClick = {recommendation ->
                        navController.navigate(Screen.RecommendationDescription.createRoute(recommendation.title))
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }

            // Экран с описание рекомендации
            composable(
                route = Screen.RecommendationDescription.route,
                arguments = listOf(navArgument("title") { type = NavType.StringType })
            ) { backStackEntry ->
                val title = backStackEntry.arguments?.getString("title") ?: ""
                val recommendation = recommendations.find { it.title == title }
                recommendation?.let {
                    RecommendationDescriptionScreen(
                        recommendation = recommendation,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    )
                }

            }
        }

    }

}