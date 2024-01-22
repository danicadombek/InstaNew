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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.instaclone.DestinationScreen
import com.example.instaclone.IgViewModel
import com.example.instaclone.R
import com.example.instaclone.main.CheckSignedIn
import com.example.instaclone.main.CommonProgressSpinner
import com.example.instaclone.main.navigateTo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController, vm: IgViewModel) {

    CheckSignedIn(navController = navController, vm = vm)

    val focus = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .verticalScroll(
                    rememberScrollState()
                )
                .padding(16.dp)
        ) {
            val emailState = remember {
                mutableStateOf(TextFieldValue())
            }
            val passState = remember {
                mutableStateOf(TextFieldValue())
            }

            Image(
                painter = painterResource(id = R.drawable.ig_logo),
                contentDescription = "logo",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .padding(top = 8.dp),
            )

            Text(
                text = "Log in",
                modifier = Modifier.padding(8.dp),
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif
            )

            OutlinedTextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = { Text("Email") },
                modifier = Modifier
                    .padding(8.dp)
            )
            OutlinedTextField(
                value = passState.value,
                onValueChange = { passState.value = it },
                label = { Text("Password") },
                modifier = Modifier
                    .padding(8.dp)
            )
            Button(onClick = {
                focus.clearFocus(force = true)
                vm.onLogin(emailState.value.text, passState.value.text)
                navigateTo(navController, DestinationScreen.Feed)
            }) {
                Text(text = "Log in")
            }

            Text(text = "New her? Go to signup",
                color = Color.Blue,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        navigateTo(navController, DestinationScreen.SignUp)
                    }
            )
        }
    }
    val isLoading = vm.inProgress.value
    if (isLoading) {
        CommonProgressSpinner()
    }
}