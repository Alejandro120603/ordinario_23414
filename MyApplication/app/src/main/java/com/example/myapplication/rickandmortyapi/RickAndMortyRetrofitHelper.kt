package com.example.myapplication.rickandmortyapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Paso 1: Helper que prepara Retrofit para conectarse a Rick and Morty API.
object RickAndMortyRetrofitHelper {

    private const val URL_BASE = "https://rickandmortyapi.com/api/"

    fun getRetrofitService(): RickAndMortyApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: RickAndMortyApiInterface =
            retrofit.create(RickAndMortyApiInterface::class.java)
        return service
    }
}
