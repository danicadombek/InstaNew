package com.example.instaclone.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.instaclone.DestinationScreen
import com.example.instaclone.IgViewModel
import com.example.instaclone.InstagramApp
import com.example.instaclone.R
import com.example.instaclone.main.CheckSignedIn
import com.example.instaclone.main.CommonProgressSpinner
import com.example.instaclone.main.navigateTo
import com.example.instaclone.ui.theme.InstaCloneTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController, vm: IgViewModel) {

    CheckSignedIn(navController = navController, vm = vm)

    val focus = LocalFocusManager.current
    var userName by remember { mutableStateOf(TextFieldValue()) }
    var email by remember { mutableStateOf(TextFieldValue()) }
    var passWord by remember { mutableStateOf(TextFieldValue()) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .verticalScroll(
                    rememberScrollState()
                )
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ig_logo),
                contentDescription = "logo",
                modifier = Modifier
                    .padding(16.dp),
            )
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                label = { Text("Username") },
                modifier = Modifier
                    .padding(8.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .padding(8.dp)
            )
            OutlinedTextField(
                value = passWord,
                onValueChange = { passWord = it },
                label = { Text("Password") },
                modifier = Modifier
                    .padding(8.dp)
            )
            Button(onClick = {
                focus.clearFocus(force = true)
                vm.onSignUp(
                    userName.text,
                    email.text,
                    passWord.text
                )
            }) {
                Text(text = "Sign up")
            }
            Text(text = "Already a user? Go to login",
                color = Color.Blue,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        navigateTo(navController, DestinationScreen.LogIn)
                    }
            )
        }
        val isLoading = vm.inProgress.value
        if (isLoading) {
            CommonProgressSpinner()
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    InstaCloneTheme {
//        SignUpScreen(navController = navController, vm = vm)
//    }
//}

// navController: Navigation