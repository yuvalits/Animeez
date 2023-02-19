package com.animeez.models.recommendations.animeRecommendations

import com.google.gson.annotations.SerializedName

data class AnimeRecommendation(
    val content: String,
    val date: String,
    @SerializedName("mal_id")
    val malId: String,
    val user: User
)