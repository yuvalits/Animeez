package com.animeez.models.magazines

import com.google.gson.annotations.SerializedName

data class Magazine(
    val count: String,
    @SerializedName("mal_id")
    val malId: String,
    val name: String,
    @SerializedName("url")
    val malUrl: String
)