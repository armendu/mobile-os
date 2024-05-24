package com.example.plantapp.screens.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController

@Composable
fun SignUpScreen(navigationController: NavController) {

    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
}