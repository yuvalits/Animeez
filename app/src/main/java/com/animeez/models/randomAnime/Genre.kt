package com.animeez.models.randomAnime

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("mal_id")
    val malId: Int,
    val name: String,
    val type: String,
    @SerializedName("url")
    val malUrl: String
)