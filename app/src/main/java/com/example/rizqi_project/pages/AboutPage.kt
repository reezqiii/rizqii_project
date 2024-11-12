package com.example.rizqi_project.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import com.example.rizqi_project.R

@Composable
fun AboutPage(modifier: Modifier = Modifier) {
    val name = remember { mutableStateOf("Rizqi Vela Syifa") }
    val email = remember { mutableStateOf("velasyifa02@gmail.com") }
    val kampus = remember { mutableStateOf("Politeknik Negeri Batam") }
    val jurusan = remember { mutableStateOf("Teknik Informatika") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFBFBFB))
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile Image
            Surface(
                modifier = Modifier.size(200.dp),
                shape = CircleShape,
                color = Color.Gray
            ) {
                Image(
                    painter = painterResource(id = R.drawable.p11),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(120.dp)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Input Fields
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                OutlinedTextField(
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = { Text("Nama") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = email.value,
                    onValueChange = { email.value = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = kampus.value,
                    onValueChange = { kampus.value = it },
                    label = { Text("Kampus") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = jurusan.value,
                    onValueChange = { jurusan.value = it },
                    label = { Text("Jurusan") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
