package com.example.ordinario_23414.ordinario

import com.google.gson.annotations.SerializedName

//campos que quiremos
data class ChuckNorrisResponse(
    val id: String?,
    @SerializedName("icon_url")
    val iconUrl: String?,
    val value: String?
)
