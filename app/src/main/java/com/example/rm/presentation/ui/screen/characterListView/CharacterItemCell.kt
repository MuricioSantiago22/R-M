package com.example.rm.presentation.ui.screen.characterListView

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.rm.domain.entities.Character
import com.example.rm.presentation.navigation.Routes
import com.example.rm.presentation.viewModel.SharedViewModel

@Composable
fun ProductItem(
    sharedViewModel: SharedViewModel,
    navController: NavController,
    character: Character
){
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        AsyncImage(
            model = character.image,
            contentDescription ="Character Image" ,
            modifier = Modifier
                .size(200.dp)
                .background(Color.White.copy(alpha = 0.1f))
                .padding(8.dp)
                .clickable {
                    sharedViewModel.addCharacter(character)
                    navController.navigate(
                        route = Routes.CharacterDetailScreen.route
                    )
                }
        )
        Spacer(
            modifier = Modifier
                .padding(4.dp)
        )
        Column {
            character.name.let {
                Text(
                    it,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}