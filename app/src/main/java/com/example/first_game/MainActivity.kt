package com.example.first_game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.composable
import com.example.first_game.pages.Intro
import com.example.first_game.pages.Welcome
import com.example.first_game.ui.theme.FirstgameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstgameTheme {
                val navController: NavHostController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Set up the navigation graph
                    NavHost(navController, startDestination = "main") {
                        // MainScreen destination
                        composable("main") {
                            Intro(navController)
                        }

                        // WelcomePage destination with dynamic name parameter
                        composable("welcome/{name}") { backStackEntry ->
                            val name = backStackEntry.arguments?.getString("name") ?: ""
                            Welcome(name = name)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        FirstgameTheme {
            Greeting("Android")
        }
    }
}