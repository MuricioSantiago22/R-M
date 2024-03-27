package com.example.rm.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rm.presentation.ui.screen.characterDetailView.CharacterDetailScreen
import com.example.rm.presentation.ui.screen.characterListView.CharacterListScreen
import com.example.rm.presentation.ui.screen.splashView.SplashScreen


@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SplashScreen.route ){
        composable(route = Routes.SplashScreen.route){
            SplashScreen(
                navController = navController
            )
        }
        composable(
            route = Routes.CharacterLisScreen.route
        ){
            CharacterListScreen(
                navController= navController
            )
        }
        composable(
            route= Routes.CharacterDetailScreen.route
        ){
            CharacterDetailScreen(
                navController = navController
            )
        }
    }
}