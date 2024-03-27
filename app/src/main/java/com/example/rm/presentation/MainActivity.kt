package com.example.rm.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.rm.presentation.navigation.AppNavigation
import com.example.rm.presentation.ui.theme.RMTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RMTheme {
                MyActivityUi()
            }
        }
    }
}
    @Composable
    fun MyActivityUi(){
        AppNavigation()
    }