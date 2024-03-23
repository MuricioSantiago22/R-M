package com.example.rm.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.rm.data.local.entities.CharacterEntity

interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacterList(list:List<CharacterEntity>)
}