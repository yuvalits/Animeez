package com.animeez.models.randomAnime

import com.google.gson.annotations.SerializedName

data class RandomAnime(
    val aired: Aired,
    val airing: Boolean,
    val approved: Boolean,
    val background: Any,
    val broadcast: Broadcast,
    val demographics: List<Any>,
    val duration: String,
    val episodes: Int,
    @SerializedName("explicit_genres")
    val explicitGenres: List<Any>,
    val favorites: Int,
    val genres: List<Genre>,
    val images: Images,
    val licensors: List<Any>,
    @SerializedName("mal_id")
    val malId: Int,
    val members: Int,
    val popularity: Int,
    val producers: List<Any>,
    val rank: Int,
    val rating: String,
    val score: Any,
    @SerializedName("scored_by")
    val scoredBy: Any,
    val season: Any,
    val source: String,
    val status: String,
    val studios: List<Any>,
    val synopsis: Any,
    val themes: List<Theme>,
    val title: String,
    @SerializedName("title_english")
    val titleEnglish: String,
    @SerializedName("title_japanese")
    val titleJapanese: String,
    @SerializedName("title_synonyms")
    val titleSynonyms: List<Any>,
    val titles: List<Title>,
    val trailer: Trailer,
    val type: String,
    @SerializedName("url")
    val malUrl: String,
    val year: Any
)