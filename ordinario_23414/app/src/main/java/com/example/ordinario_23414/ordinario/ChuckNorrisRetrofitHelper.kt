package com.example.ordinario_23414.ordinario

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//
object ChuckNorrisRetrofitHelper {
    private const val URL_BASE = "https://api.chucknorris.io/"

    fun getRetrofitService(): ChuckNorrisApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ChuckNorrisApiInterface::class.java)
    }
}