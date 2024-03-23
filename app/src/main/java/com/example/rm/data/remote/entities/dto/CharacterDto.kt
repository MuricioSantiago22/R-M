package com.example.rm.data.remote.entities.dto

import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("name")
    val name : String? = null,
    @SerializedName("image")
    val image : String? = null,
)
