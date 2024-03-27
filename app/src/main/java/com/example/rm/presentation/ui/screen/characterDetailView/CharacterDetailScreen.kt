package com.example.rm.presentation.ui.screen.characterDetailView


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailScreen(
    navController: NavController,
){
    val topAppBarTextStyle = MaterialTheme.typography.headlineSmall
        .copy(fontWeight = FontWeight.Bold)
    Scaffold(
        topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Datos",
                    textAlign = TextAlign.Center,
                    style = topAppBarTextStyle,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.Green,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White
            )
        )

    }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            AsyncImage(
                model = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                contentDescription ="Character Image" ,
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.White.copy(alpha = 0.1f))
                    .padding(8.dp)
            )
        }
    }
}