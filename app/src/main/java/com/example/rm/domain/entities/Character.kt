package com.example.rm.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize



@Parcelize
data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val specie: String,
    val type: String,
    val gender: String,
    val image: String
): Parcelable


