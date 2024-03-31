package com.example.rm.presentation.navigation


sealed class Routes(val route: String) {
    object SplashScreen : Routes("splash_screen")
    object CharacterLisScreen : Routes("list_screen")
    object CharacterDetailScreen : Routes("detail_screen")

}

