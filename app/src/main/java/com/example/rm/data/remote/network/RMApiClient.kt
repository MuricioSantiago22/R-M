package com.example.rm.data.remote.network
import com.example.rm.data.remote.entities.result.CharacterResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface RMApiClient {
    @GET("character/")
    suspend fun getCharacters(
        @Query("page") pageNumber: Int
    ):Response<CharacterResult>
}