package com.example.rm.data.remote.entities.dto

import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name : String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("species")
    val specie: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("image")
    val image : String? = null,
)
