package com.example.rizqi_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.rizqi_project.data.Food
import com.example.rizqi_project.ui.theme.Rizqi_ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Rizqi_ProjectTheme {
                MainScreen(
                    navigateToProfile = { food: Food ->
                        println("Navigating to profile of ${food.category}")
                    }
                )
            }
        }
    }
}
