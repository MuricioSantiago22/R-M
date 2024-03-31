package com.example.rm.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "character_table")
data class CharacterEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name= "id") var id : Int,
    @ColumnInfo(name = "name")var name :String,
    @ColumnInfo(name = "status") var status: String,
    @ColumnInfo(name = "specie") var specie: String,
    @ColumnInfo(name = "type") var type: String,
    @ColumnInfo(name = "gender") var gender: String,
    @ColumnInfo(name= "image") var image: String
)