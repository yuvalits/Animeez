package com.animeez.models.genres

import com.google.gson.annotations.SerializedName

data class Genre(
    val count: String,
    @SerializedName("mal_id")
    val malId: String,
    val name: String,
    @SerializedName("url")
    val malUrl: String
)