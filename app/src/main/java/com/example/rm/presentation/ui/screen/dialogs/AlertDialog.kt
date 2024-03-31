package com.example.rm.presentation.ui.screen.dialogs

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.rm.presentation.navigation.Routes


@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route?.substringBeforeLast("/")
}
@Composable
fun AlertDialogExit(
    navController: NavController,
    cancel: (isOpen:Boolean) -> Unit,
    ok: () -> Unit
){
    val openDialog = remember { mutableStateOf(true) }
    if (
        currentRoute(
            navController = navController) == Routes.CharacterLisScreen.route && openDialog.value
        ){
        AlertDialog(
            titleContentColor = Color.Magenta,
            onDismissRequest = {
                openDialog.value = false
                cancel(false)
                               },
            title = { Text(text = "Warning")},
            text = {
                Text(
                    text = "Are you sure you want to exit the application?"
                )},
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        ok()
                    }
                ){
                    Text(
                        text = "Confirm",
                        color= Color.Magenta
                    )
                }
                        },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        cancel(false)
                    }
                ){
                    Text(
                        text = "Dismiss",
                        color = Color.Magenta
                    )
                }
            }
        )
    }
}

