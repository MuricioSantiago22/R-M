package com.example.rm.presentation.navigation

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rm.presentation.ui.screen.characterDetailView.CharacterDetailScreen
import com.example.rm.presentation.ui.screen.characterListView.CharacterListScreen
import com.example.rm.presentation.ui.screen.dialogs.AlertDialogExit
import com.example.rm.presentation.ui.screen.dialogs.currentRoute
import com.example.rm.presentation.ui.screen.splashView.SplashScreen
import com.example.rm.presentation.viewModel.SharedViewModel


@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    val sharedViewModel: SharedViewModel = viewModel()
    val openDialog = remember { mutableStateOf(false) }
    val activity = (LocalContext.current as? Activity)
    BackHandler(enabled = (currentRoute(navController) ==Routes.CharacterLisScreen.route)) {
        openDialog.value = true
    }
    NavHost(navController = navController, startDestination = Routes.SplashScreen.route ) {
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
            if (openDialog.value) {
                AlertDialogExit(
                    navController,
                    { openDialog.value = it },
                    { activity?.finish() }
                )
            }
        }
        composable(
            route= Routes.CharacterDetailScreen.route
        ){

            CharacterDetailScreen(
                navController = navController,
                sharedViewModel

            )
        }
    }
}

