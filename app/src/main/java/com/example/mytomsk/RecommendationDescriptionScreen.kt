package com.example.mytomsk

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.MyTomskTheme
import com.example.mytomsk.data.Datasource
import com.example.mytomsk.data.Recommendation



@Composable
fun RecommendationDescriptionScreen(
    recommendation: Recommendation,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = recommendation.image),
            contentDescription = recommendation.title,
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.height(20.dp))
        Surface {
            Text(
                text = recommendation.description,
                fontSize = 24.sp
            )
        }
    }
    
}

@Composable
@Preview(showBackground = true)
fun RecommendationDescriptionScreen() {
    MyTomskTheme {
        RecommendationDescriptionScreen(
            recommendation = Datasource.recommendation[5],
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)

            )
    }
}