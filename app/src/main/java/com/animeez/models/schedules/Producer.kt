package com.animeez.models.schedules

import com.google.gson.annotations.SerializedName

data class Producer(
    @SerializedName("mal_id")
    val malId: Int,
    val name: String,
    val type: String,
    @SerializedName("url")
    val malUrl: String
)