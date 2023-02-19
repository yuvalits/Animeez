package com.animeez.models.recommendations.animeRecommendations

data class AnimeRecommendationsResponse(
    val animeRecommendations: List<AnimeRecommendation>,
    val pagination: Pagination
)