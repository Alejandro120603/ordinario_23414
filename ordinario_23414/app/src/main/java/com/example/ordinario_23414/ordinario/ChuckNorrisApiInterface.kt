package com.example.ordinario_23414.ordinario

import retrofit2.Response
import retrofit2.http.GET
//cosa del endoint random
interface ChuckNorrisApiInterface {
    @GET("jokes/random")
    suspend fun getChisteRandom(): Response<ChuckNorrisResponse>
}