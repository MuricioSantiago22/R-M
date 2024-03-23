package com.example.rm.data.repository

import com.example.rm.data.local.dao.CharacterDao
import com.example.rm.data.remote.mapper.toDomain
import com.example.rm.data.remote.network.RMApiClient
import com.example.rm.domain.entities.Character
import com.example.rm.domain.repository.CharacterListRepository
import javax.inject.Inject

class CharacterListRepositoryImpl @Inject constructor(
    private val client:RMApiClient,
    private val characterDao: CharacterDao
):CharacterListRepository {
    override suspend fun getCharacterList(pageNumber: Int): List<Character> =
       client.getCharacters(pageNumber).result.map { it!!.toDomain()}


}