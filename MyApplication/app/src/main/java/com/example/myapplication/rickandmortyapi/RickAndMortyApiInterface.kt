package com.example.myapplication.rickandmortyapi

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

// Paso 1: Interface de Retrofit para describir las consultas a Rick and Morty API.
interface RickAndMortyApiInterface {

    @GET("character")
    suspend fun getCharactersInfo(): Response<RickAndMortyListResponse>

    @GET("character/{id}")
    suspend fun getCharacterById(
        @Path("id") id: Int
    ): Response<RickAndMortyResponse>
}
