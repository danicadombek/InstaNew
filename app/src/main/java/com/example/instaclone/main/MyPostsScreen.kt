package com.example.instaclone.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.instaclone.IgViewModel

@Composable
fun MyPostsScreen(navController: NavController, vm: IgViewModel) {

    val userData = vm.userData.value
    val isLoading = vm.inProgress.value

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
            Row {
                ProfileImage(userData?.imageUrl) {

                }
                Text(
                    text = "15\nposts",
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "54\nfollowers",
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "60\nfollowing",
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    textAlign = TextAlign.Center
                )
            }
            Column(modifier = Modifier.padding(8.dp)) {
                val userNameDisplay = if (userData?.userName == null) "" else "@${userData.userName}"
                Text(text = userData?.userName ?: "", fontWeight = FontWeight.Bold)
                Text(text = userNameDisplay)
                Text(text = userData?.bio ?: "")
            }
            OutlinedButton(onClick = {  },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
//                elevation = ButtonElevation(defa)
                shape = RoundedCornerShape(10)
            ) {
                    Text(text = "Edit profile", color = Color.LightGray)
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "List of posts")
            }
        }
        BottomNavigationMenu(
            selectedItem = BottomNavigationItem.MYPOSTS,
            navController = navController)
    }
}

@Composable
fun ProfileImage(imageUrl: String?, onClick: () -> Unit) {

}