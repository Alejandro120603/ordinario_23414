package com.example.myapplication.rickandmortyapi

// Paso 1: Clase intermedia entre el ViewModel y Retrofit.
class RickAndMortyAPI {
    private val service = RickAndMortyRetrofitHelper.getRetrofitService()

    suspend fun getPersonajeAleatorio(): RickAndMortyResponse? {
        // Paso 2: Consultar el total actual de personajes para no usar un ID fijo.
        val infoResponse = service.getCharactersInfo()
        val characterCount = infoResponse.body()?.info?.count

        if (!infoResponse.isSuccessful || characterCount == null || characterCount <= 0) {
            return null
        }

        // Paso 3: Generar ID random cada vez que se ejecuta la consulta.
        val randomId = (1..characterCount).random()
        val response = service.getCharacterById(randomId)

        // Paso 4: Regresar el body solo si la respuesta fue exitosa.
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}
