package com.example.rm.data.remote.entities.dto

import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name : String? = null,
    @SerializedName("image")
    val image : String? = null,
)
