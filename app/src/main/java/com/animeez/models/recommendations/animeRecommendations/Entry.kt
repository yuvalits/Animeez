package com.animeez.models.recommendations.animeRecommendations

import com.google.gson.annotations.SerializedName

data class Entry(
    val images: Images,
    @SerializedName("mal_id")
    val malId: Int,
    val title: String,
    @SerializedName("url")
    val malUrl: String
)