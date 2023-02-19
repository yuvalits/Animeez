package com.animeez.services

import com.animeez.JIKAN_MANGA_RECOMMENDATIONS
import com.animeez.models.recommendations.mangaRecommendations.MangaRecommendation
import com.animeez.utils.IO
import org.json.JSONObject

class MangaRecommendationsService {
    companion object{
        fun fetchMangaRecommendations(callback: (MangaRecommendations: List<MangaRecommendation>)-> Unit) {
            IO.fetchFromUrl(JIKAN_MANGA_RECOMMENDATIONS) { receivedJson ->
                val json = JSONObject(receivedJson) //casting for us using this class
                val resultsArray = json.getJSONArray("results") //get the json as an array
                val fetchedMangaRecommendation = mutableListOf<MangaRecommendation>()


                for (i in 0 until resultsArray.length()) {
                    val mangaRecommendationObject = resultsArray.getJSONObject(i)

                    val content = mangaRecommendationObject.getString("content")
                    val date = mangaRecommendationObject.getString("date")
                    val malId = mangaRecommendationObject.getString("malId")
                    val user = mangaRecommendationObject.getString("user")

                    fetchedMangaRecommendation.add(MangaRecommendation(
                        content, date, malId, user
                    ))
                }
                callback(fetchedMangaRecommendation)
            }
        }
    }
}