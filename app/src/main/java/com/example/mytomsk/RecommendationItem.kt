package com.example.mytomsk

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.MyTomskTheme
import com.example.mytomsk.data.Category
import com.example.mytomsk.data.Datasource
import com.example.mytomsk.data.Recommendation


@Composable
fun RecommendationItem(
    recommendation: Recommendation,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = recommendation.image),
                contentScale = ContentScale.Crop,
                contentDescription = recommendation.title,
                modifier = Modifier

                    .size(150.dp)
            )
            Text(
                text = recommendation.title,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RecommendationItemPreview() {
    MyTomskTheme {
        RecommendationItem(
            recommendation = Datasource.recommendation.first(),
            modifier = Modifier.fillMaxWidth()
        )
    }
}