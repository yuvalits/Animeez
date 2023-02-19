package com.animeez.models.recommendations.animeRecommendations

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("url")
    val malUrl: String,
    @SerializedName("username")
    val malUserName: String
)