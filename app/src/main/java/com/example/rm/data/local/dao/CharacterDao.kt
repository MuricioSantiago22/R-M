package com.example.rm.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rm.data.local.entities.CharacterEntity

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character_table")
    fun getAllCharacters(): List<CharacterEntity>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCharacterList(list:List<CharacterEntity>)

    @Query("SELECT * FROM character_table WHERE id = :characterId")
    suspend fun getCharacterById(characterId: Int): CharacterEntity?
}