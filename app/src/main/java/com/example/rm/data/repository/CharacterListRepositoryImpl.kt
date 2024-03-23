package com.example.rm.data.repository

import com.example.rm.data.remote.mapper.toDomain
import com.example.rm.data.remote.network.RMApiClient
import com.example.rm.domain.entities.Character
import com.example.rm.domain.repository.CharacterListRepository
import javax.inject.Inject

class CharacterListRepositoryImpl @Inject constructor(
    private val client:RMApiClient
):CharacterListRepository {
    override suspend fun getCharacterList(pageNumber: Int): List<Character> =
       client.getCharacters(pageNumber).body()!!.result.map { it!!.toDomain() }

}