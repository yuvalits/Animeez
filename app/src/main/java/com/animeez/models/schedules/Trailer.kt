package com.animeez.models.schedules

import com.google.gson.annotations.SerializedName

data class Trailer(
    @SerializedName("embed_url")
    val embedUrl: Any,
    val images: ImagesX,
    @SerializedName("url")
    val malUrl: Any,
    @SerializedName("youtube_id")
    val youtubeId: Any
)