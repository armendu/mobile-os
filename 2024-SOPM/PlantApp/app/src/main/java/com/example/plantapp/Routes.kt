package com.example.plantapp

sealed class Routes(val routeName: String) {
    data object Login: Routes("Login")

    data object Main: Routes("Main")

    data object Content: Routes("Content")
}