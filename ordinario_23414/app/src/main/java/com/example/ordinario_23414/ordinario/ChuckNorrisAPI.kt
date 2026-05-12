package com.example.ordinario_23414.ordinario

class ChuckNorrisAPI {

    private val service = ChuckNorrisRetrofitHelper.getRetrofitService()

    suspend fun getChisteRandom(): ChuckNorrisResponse? {
        val response = service.getChisteRandom()

        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}

