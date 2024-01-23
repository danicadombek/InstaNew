package com.example.instaclone.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.instaclone.IgViewModel

@Composable
fun FeedScreen(navController: NavController, vm: IgViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(text = "Feed screen", fontSize = 32.sp)
        }
        BottomNavigationMenu(selectedItem = BottomNavigationItem.FEED, navController = navController)
    }
}