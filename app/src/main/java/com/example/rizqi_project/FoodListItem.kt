package com.example.rizqi_project

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rizqi_project.data.DataProvider
import com.example.rizqi_project.data.Food

@Composable
fun FoodListItemForHomePage(food: Food, navigateToProfile: (Food) -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF6FAF7)),
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable { navigateToProfile(food) },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            FoodImage(food = food)
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = food.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "View Detail",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun FoodListItemForListPage(food: Food, navigateToProfile: (Food) -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF6FAF7)),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { navigateToProfile(food) },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            FoodImage(food = food)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = food.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "View Detail",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun FoodImage(food: Food) {
    Image(
        painter = painterResource(id = food.foodImageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}

@Preview
@Composable
fun PreviewFoodListItemForHomePage() {
    val food = DataProvider.foodList[0]
    FoodListItemForHomePage(food = food, navigateToProfile = {})
}

@Preview
@Composable
fun PreviewFoodGridItemForListPage() {
    val food = DataProvider.foodList[0]
    FoodListItemForListPage(food = food, navigateToProfile = {})
}