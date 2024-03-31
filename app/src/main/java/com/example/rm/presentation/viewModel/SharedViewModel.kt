package com.example.rm.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.rm.domain.entities.Character

class SharedViewModel: ViewModel() {

    var character by mutableStateOf<Character?>(null)
        private set

    fun addCharacter(newCharacter:Character){
        character = newCharacter
    }
}