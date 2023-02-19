package com.animeez.models.recommendations.mangaRecommendations

data class MangaRecommendationsResponse(
    val mangaRecommendations: List<MangaRecommendation>,
    val pagination: Pagination
)