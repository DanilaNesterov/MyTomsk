package com.example.mytomsk

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.mytomsk.data.Category
import com.example.mytomsk.data.Datasource
import com.example.mytomsk.data.Recommendation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyTomskViewModel: ViewModel() {
    // Список категорий
    private val _categories = MutableStateFlow<List<Category>>(mutableStateListOf())
    val categories = _categories.asStateFlow()

    // Список рекомендаций
    private val _recommendations = MutableStateFlow<List<Recommendation>>(mutableStateListOf())
    val recommendation = _recommendations.asStateFlow()

    init {
        _categories.value = loadCategories()
        _recommendations.value = loadRecommendation()
    }

    private fun loadCategories(): List<Category> {
        return Datasource.categories
    }

    private fun loadRecommendation(): List<Recommendation> {
        return Datasource.recommendation
    }

}