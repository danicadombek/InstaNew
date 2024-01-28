package com.example.instaclone.main

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.instaclone.DestinationScreen
import com.example.instaclone.IgViewModel
import com.example.instaclone.R

@Composable
fun NotificationMessage(vm: IgViewModel) {
    val notifState = vm.popUpNotification.value
    val notifMessage = notifState?.getContentOrNull()
    if (notifMessage != null) {
        Toast.makeText(LocalContext.current, notifMessage, Toast.LENGTH_LONG).show()
    }
}

@Composable
fun CommonProgressSpinner() {
    Row(
        modifier = Modifier
            .alpha(0.5f)
            .background(Color.LightGray)
            .clickable(enabled = false) { }
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularProgressIndicator()
    }
}

fun navigateTo(navController: NavController, dest: DestinationScreen) {
    navController.navigate(dest.route) {
        popUpTo(dest.route)
        launchSingleTop = true
    }
}

@Composable
fun CheckSignedIn(navController: NavController, vm : IgViewModel) {
    val alreadyLoggedIn = remember { mutableStateOf(false) }
    val signedIn = vm.signedIn.value
    if (signedIn && !alreadyLoggedIn.value) {
        alreadyLoggedIn.value = true
        navController.navigate(DestinationScreen.MyPosts.route) {
            popUpTo(0)
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CommonImage(
    data: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop
) {
    val painter = rememberImagePainter(
        data = data,
        builder = {
            transformations(CircleCropTransformation()) // Optional: Transformations
        }
    )

    Image(
        painter = painter,
        contentDescription = "",
        modifier = modifier.graphicsLayer(
            scaleX = if (painter.state is ImagePainter.State.Success) 1f else 0.8f,
            scaleY = if (painter.state is ImagePainter.State.Success) 1f else 0.8f
        ),
        contentScale = contentScale
    )

    if (painter.state is ImagePainter.State.Loading) {
        CommonProgressSpinner()
    }
}


@Composable
fun UserImageCard(
    userImage: String?,
    modifier: Modifier = Modifier
) {
    Card(
        shape = CircleShape,
        modifier = modifier
            .padding(8.dp)
            .size(64.dp),
        ) {
        if (userImage.isNullOrEmpty()) {
            Image(
                painter = painterResource(id = R.drawable.ic_account),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.Gray),
                modifier = modifier
                    .fillMaxSize()
            )
        } else {
            CommonImage(data = userImage)
        }
    }

    }