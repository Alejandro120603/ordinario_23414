package com.example.myapplication.rickandmortyapi

// Paso 1: Modelo que representa solo los campos del personaje que vamos a usar.
data class RickAndMortyResponse(
    val name: String?,
    val status: String?,
    val species: String?,
    val gender: String?,
    val image: String?
)

// Paso 2: Modelo mínimo para conocer cuántos personajes existen y generar el random.
data class RickAndMortyListResponse(
    val info: RickAndMortyInfo?
)

data class RickAndMortyInfo(
    val count: Int?
)
