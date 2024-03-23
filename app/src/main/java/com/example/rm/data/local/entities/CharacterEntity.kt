package com.example.rm.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "character_table")
data class CharacterEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name= "id") var id : Int,
    @ColumnInfo(name = "name")var name :String,
    @ColumnInfo(name= "image") var image: String
)
