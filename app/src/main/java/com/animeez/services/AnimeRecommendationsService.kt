package com.animeez.services

import com.animeez.JIKAN_ANIME_RECOMMENDATIONS
import com.animeez.models.recommendations.animeRecommendations.AnimeRecommendation
import com.animeez.models.recommendations.animeRecommendations.User
import com.animeez.utils.IO
import org.json.JSONObject

class AnimeRecommendationsService {
    companion object{
        fun fetchAnimeRecommendations(callback: (AnimeRecommendations: List<AnimeRecommendation>)-> Unit) {
            IO.fetchFromUrl(JIKAN_ANIME_RECOMMENDATIONS) { receivedJson ->
                val json = JSONObject(receivedJson) //casting for us using this class
                val resultsArray = json.getJSONArray("results") //get the json as an array
                val fetchedAnimeRecommendation = mutableListOf<AnimeRecommendation>()


                for (i in 0 until resultsArray.length()) {
                    val animeRecommendationObject = resultsArray.getJSONObject(i)

                    val content = animeRecommendationObject.getString("content")
                    val date = animeRecommendationObject.getString("date")
                    val malId = animeRecommendationObject.getString("malId")
                    val user = animeRecommendationObject.getString("user")

                    fetchedAnimeRecommendation.add(AnimeRecommendation(
                    content, date, malId = String(), user = User(malId, user)
                    ))
                }
                callback(fetchedAnimeRecommendation)
            }
        }
    }
}