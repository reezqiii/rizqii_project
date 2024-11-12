package com.example.rizqi_project.data

import java.io.Serializable

data class Food(
    val id: Int,
    val name: String,
    val category: String,
    val price: Double,
    val description: String,
    val foodImageId: Int = 0
    )  : Serializable
