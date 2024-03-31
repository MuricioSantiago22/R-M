package com.example.rm.presentation.navigation

import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rm.domain.entities.Character
import com.example.rm.presentation.ui.screen.characterDetailView.CharacterDetailScreen
import com.example.rm.presentation.ui.screen.characterListView.CharacterListScreen
import com.example.rm.presentation.ui.screen.splashView.SplashScreen
import com.example.rm.presentation.viewModel.SharedViewModel
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    val sharedViewModel: SharedViewModel = viewModel()
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
                navController= navController,
                sharedViewModel
            )
        }
        composable(
            route= Routes.CharacterDetailScreen.route
        ){

            val result =
                navController.previousBackStackEntry?.savedStateHandle?.get<Character>("character")

            CharacterDetailScreen(
                navController = navController,
                sharedViewModel

            )
        }
    }
}

inline fun <reified T:Parcelable> NavType.Companion.parcelableTypeOf()=
    object : NavType<T>(isNullableAllowed = false){

    override fun put(bundle: Bundle, key: String, value: T) {
        bundle.putParcelable(key, value)
    }
    override fun get(bundle: Bundle, key: String): T? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): T {
        return Json.decodeFromString(Uri.decode(value))
    }
}
