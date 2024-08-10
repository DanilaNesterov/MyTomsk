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
import com.example.mytomsk.data.Category
import com.example.mytomsk.data.CategoryType
import com.example.mytomsk.data.Datasource



@Composable
fun CategoryList(
    categories: List<Category>,
    onCategoryClick: (CategoryType) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(categories) { category ->
            CategoryItem(category = category, modifier = Modifier.clickable { onCategoryClick(category.type) })
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CategoryListPreview() {
    MyTomskTheme {
        CategoryList(
            categories = Datasource.categories,
            onCategoryClick = {}
        )
    }
}