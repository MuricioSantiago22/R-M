package com.example.rm.presentation.navigation

import android.net.Uri
import android.os.Parcelable
import com.example.rm.domain.entities.Character
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

interface ParcelableNav{
    fun encodeValue(parcelable: Parcelable):String{
        return Uri.encode(Json.encodeToJsonElement(parcelable).toString())
    }
}

sealed class Routes(val route: String) {
    object SplashScreen : Routes("splash_screen")
    object CharacterLisScreen : Routes("list_screen")
    object CharacterDetailScreen : Routes("detail_screen")

}
enum class NavArgs(val key: String){
    Character("character")
}
