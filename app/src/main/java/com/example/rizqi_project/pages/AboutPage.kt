package com.example.rizqi_project.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rizqi_project.R

@Composable
fun AboutPage(modifier: Modifier = Modifier) {
    val name = remember { mutableStateOf("Rizqi Vela Syifa") }
    val email = remember { mutableStateOf("velasyifa02@gmail.com") }
    val kampus = remember { mutableStateOf("Politeknik Negeri Batam") }
    val jurusan = remember { mutableStateOf("Teknik Informatika") }
    val prodi = remember { mutableStateOf("Teknik Informatika") }
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFBFBFB))
            .verticalScroll(scrollState)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF6FAF7)), // Updated color
                elevation = CardDefaults.cardElevation(8.dp),
                modifier = Modifier.size(200.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.p11),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            InfoCard(label = "Nama", value = name.value)
            Spacer(modifier = Modifier.height(8.dp))

            InfoCard(label = "Email", value = email.value)
            Spacer(modifier = Modifier.height(8.dp))

            InfoCard(label = "Kampus", value = kampus.value)
            Spacer(modifier = Modifier.height(8.dp))

            InfoCard(label = "Jurusan", value = jurusan.value)
            Spacer(modifier = Modifier.height(8.dp))

            InfoCard(label = "Prodi", value = prodi.value)
        }
    }
}

@Composable
fun InfoCard(label: String, value: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF6FAF7)), // Updated color
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = label, fontSize = 12.sp, color = Color.Gray)
            Text(text = value, fontSize = 14.sp, color = Color.Black)
        }
    }
}