package com.animeez.models.recommendations.mangaRecommendations

import com.google.gson.annotations.SerializedName

data class MangaRecommendation(
    val content: String,
    val date: String,
    val entry: String,
    @SerializedName("mal_id")
    val malId: String
)