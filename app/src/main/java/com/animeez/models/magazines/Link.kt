package com.animeez.models.magazines

import com.google.gson.annotations.SerializedName

data class Link(
    val active: Boolean,
    val label: String,
    @SerializedName("url")
    val malUrl: String
)