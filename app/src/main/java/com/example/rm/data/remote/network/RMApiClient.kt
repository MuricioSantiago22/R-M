package com.example.rm.data.remote.network
import com.example.rm.data.remote.entities.result.CharacterResult

import retrofit2.http.GET
import retrofit2.http.Query


interface RMApiClient {
    @GET("api/character/")
    suspend fun getCharacters(
        @Query("page") pageNumber: Int,
        @Query("name") searchString: String
    ):CharacterResult
}