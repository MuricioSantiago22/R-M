package com.example.rm.data.remote.entities.result

import com.example.rm.data.remote.entities.dto.CharacterDto
import com.google.gson.annotations.SerializedName


data class CharacterResult(
    @SerializedName("results")
    val result : List<CharacterDto?> = listOf()
)
