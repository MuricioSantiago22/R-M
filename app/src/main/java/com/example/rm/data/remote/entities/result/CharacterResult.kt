package com.example.rm.data.remote.entities.result

import com.example.rm.data.remote.entities.dto.CharacterDto


data class CharacterResult(
    val result : List<CharacterDto?> = listOf()
)
