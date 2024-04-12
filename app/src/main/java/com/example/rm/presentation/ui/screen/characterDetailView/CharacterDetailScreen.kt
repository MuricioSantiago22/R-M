package com.example.rm.presentation.ui.screen.characterDetailView


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.rm.presentation.viewModel.SharedViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel

){
    val character = sharedViewModel.character
    val topAppBarTextStyle = MaterialTheme.typography.headlineSmall
        .copy(fontWeight = FontWeight.Bold)
    Scaffold(
        topBar = {
        TopAppBar(
            title = {
                Text(
                    text = character?.name ?: "",
                    textAlign = TextAlign.Center,
                    style = topAppBarTextStyle,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.Green,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White
            ),
            navigationIcon = {
                IconButton(onClick = {navController.popBackStack()}) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back" , tint = Color.White)
                }
            }
        )

    }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(30.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            AsyncImage(
                model = character?.image,
                contentDescription ="Character Image" ,
                modifier = Modifier
                    .size(350.dp).align(CenterHorizontally)
                    .background(Color.White.copy(alpha = 0.1f))
                    .padding(8.dp)
            )
            Spacer(
                modifier = Modifier
                    .padding(20.dp)
            )
            Text(
                modifier = Modifier.align(CenterHorizontally),
                text= "Status: ${character?.status}",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(
                modifier = Modifier
                    .padding(20.dp)
            )
            Text(
                modifier = Modifier.align(CenterHorizontally),
                text= "Specie: ${character?.specie}",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(
                modifier = Modifier
                    .padding(20.dp)
            )
            Text(
                modifier = Modifier.align(CenterHorizontally),
                text= "Type: ${character?.type}",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(
                modifier = Modifier
                    .padding(20.dp)
            )
            Text(
                modifier = Modifier.align(CenterHorizontally),
                text= "Gender: ${character?.gender}",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}