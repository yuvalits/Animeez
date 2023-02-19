package com.animeez.models.magazines

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("current_page")
    val currentPage: Int,
    val from: Int,
    @SerializedName("last_page")
    val lastPage: Int,
    val links: List<Link>,
    val path: String,
    @SerializedName("per_page")
    val perPage: Int,
    val to: Int,
    @SerializedName("total")
    val totalPages: Int
)