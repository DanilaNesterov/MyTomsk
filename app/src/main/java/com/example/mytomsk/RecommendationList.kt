package com.example.mytomsk

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.MyTomskTheme
import com.example.mytomsk.data.CategoryType
import com.example.mytomsk.data.Datasource
import com.example.mytomsk.data.Recommendation

@Composable
fun RecommendationList(
    categoryType: CategoryType,
    recommendations: List<Recommendation>,
    onRecommendationClick: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(recommendations.filter { it.category == categoryType}) { recommendation ->
            RecommendationItem(recommendation = recommendation , modifier = Modifier.clickable { onRecommendationClick(recommendation ) })
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RecommendationListPreview() {
    MyTomskTheme {
        RecommendationList(categoryType = CategoryType.MONUMENT, recommendations = Datasource.recommendation, onRecommendationClick = {})
    }
}