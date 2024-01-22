package com.example.instaclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.instaclone.auth.SignUpScreen
import com.example.instaclone.main.NotificationMessage
import com.example.instaclone.storage.StorageScreen
import com.example.instaclone.ui.theme.InstaCloneTheme
import com.example.instaclone.auth.LoginScreen
import com.example.instaclone.main.BottomNavigationItem
import com.example.instaclone.main.BottomNavigationMenu
import com.example.instaclone.main.FeedScreen
import com.example.instaclone.main.MyPostsScreen
import com.example.instaclone.main.SearchScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstaCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InstagramApp()
                }
            }
        }
    }
}

// sealed class für alle ziel-screens
// TODO check sealed class
sealed class DestinationScreen(val route: String) {
    object SignUp: DestinationScreen("signup")
    object LogIn: DestinationScreen("login")
    object Storage: DestinationScreen("storage")
    object Feed: DestinationScreen("feed")
    object Search: DestinationScreen("search")
    object MyPosts: DestinationScreen("mypost")
}

@Composable
fun InstagramApp() {
    val vm = hiltViewModel<IgViewModel>()
    val navController = rememberNavController() // navi ohne parameter, gibt uns nav controller, damit nav host genutzt werden kann
    
    NotificationMessage(vm = vm)
    
    NavHost(navController = navController, startDestination = DestinationScreen.SignUp.route) {
        composable(DestinationScreen.SignUp.route) {
            SignUpScreen(navController = navController, vm = vm)
        }
        composable(DestinationScreen.Storage.route) {
            StorageScreen(navController = navController)
        }
        composable(DestinationScreen.LogIn.route) {
            LoginScreen(navController = navController, vm = vm)
        }
        composable(DestinationScreen.Feed.route) {
            FeedScreen(navController = navController, vm = vm)
        }
        composable(DestinationScreen.Search.route) {
            SearchScreen(navController = navController, vm = vm)
        }
        composable(DestinationScreen.MyPosts.route) {
            MyPostsScreen(navController = navController, vm = vm)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InstaCloneTheme {
        InstagramApp()
    }
}