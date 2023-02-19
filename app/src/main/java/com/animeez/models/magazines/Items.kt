package com.animeez.models.magazines

import com.google.gson.annotations.SerializedName

data class Items(
    val count: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("total")
    val totalPages: Int
)