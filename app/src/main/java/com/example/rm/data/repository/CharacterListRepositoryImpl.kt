package com.example.rm.data.repository

import com.example.rm.data.local.dao.CharacterDao
import com.example.rm.data.local.mapper.toDomain
import com.example.rm.data.remote.mapper.toEntity
import com.example.rm.data.remote.network.RMApiClient
import com.example.rm.domain.entities.Character
import com.example.rm.domain.repository.CharacterListRepository
import javax.inject.Inject

class CharacterListRepositoryImpl @Inject constructor(
    private val client:RMApiClient,
    private val characterDao: CharacterDao
):CharacterListRepository {
    override suspend fun getCharacterList(pageNumber: Int, searchString: String): List<Character> {
        val characterResponse = client.getCharacters(pageNumber, searchString).result
        val characterEntities = characterResponse.mapNotNull { it?.toEntity() }
        characterDao.insertCharacterList(characterEntities)
        return characterEntities.map { it.toDomain() }
    }
}