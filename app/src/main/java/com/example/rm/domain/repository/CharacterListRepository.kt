package com.example.rm.domain.repository
import com.example.rm.domain.entities.Character


interface CharacterListRepository {
    suspend fun getCharacterList(
        pageNumber:Int
    ):List<Character>
}