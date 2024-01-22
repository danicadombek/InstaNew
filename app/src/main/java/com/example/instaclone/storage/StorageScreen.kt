package com.example.instaclone.storage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun StorageScreen(navController: NavController) {
    Column(modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(text = "Storage")
        Spacer(modifier = Modifier.size(24.dp))
        Button(onClick = { navController.navigate("signup")}) {
            Text(text = "Back to sign up")
        }
    }
}