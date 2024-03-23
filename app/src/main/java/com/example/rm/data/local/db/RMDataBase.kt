package com.example.rm.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rm.data.local.dao.CharacterDao
import com.example.rm.data.local.entities.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
abstract class RMDataBase: RoomDatabase() {
    abstract fun getCharacterDataDao(): CharacterDao
}