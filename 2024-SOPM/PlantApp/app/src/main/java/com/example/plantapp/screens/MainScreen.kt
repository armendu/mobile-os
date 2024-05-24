package com.example.plantapp.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.plantapp.Routes
import com.example.plantapp.screens.content.ContentScreen
import com.example.plantapp.screens.login.LoginScreen

@Composable
fun MainScreen() {
    val navigationController = rememberNavController()

    NavHost(navController = navigationController, startDestination = Routes.Login.routeName) {
        composable(Routes.Login.routeName) {
            LoginScreen(navigationController)
        }

        composable(Routes.Content.routeName) {
            ContentScreen()
        }
    }
}