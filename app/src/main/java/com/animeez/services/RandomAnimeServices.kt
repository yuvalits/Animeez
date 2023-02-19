package com.animeez.services

import com.animeez.JIKAN_RANDOM_ANIME
import com.animeez.models.randomAnime.*
import com.animeez.utils.IO
import com.google.gson.annotations.SerializedName
import org.json.JSONObject

class RandomAnimeServices {
    companion object{
        fun fetchRandomAnime(callback: (randomAnimes: List<RandomAnime>)-> Unit) {
            IO.fetchFromUrl(JIKAN_RANDOM_ANIME) { receivedJson ->
                val json = JSONObject(receivedJson) //casting for us using this class
                val resultsArray = json.getJSONArray("results") //get the json as an array
                val fetchedRandomAnime = mutableListOf<RandomAnime>()


                for (i in 0 until resultsArray.length()) {
                    val randomAnimeObject = resultsArray.getJSONObject(i)

                    val aired = randomAnimeObject.getString("aired")
                    val airing = randomAnimeObject.getString("airing")
                    val approved = randomAnimeObject.getString("approved")
                    val background = randomAnimeObject.getString("background")
                    val broadcast = randomAnimeObject.getString("broadcast")
                    val demographics = randomAnimeObject.getString("demographics")
                    val duration = randomAnimeObject.getString("duration")
                    val episodes = randomAnimeObject.getString("episodes")
                    val explicitGenres = randomAnimeObject.getString("explicitGenres")
                    val favorites = randomAnimeObject.getString("favorites")
                    val genres = randomAnimeObject.getString("genres")
                    val images = randomAnimeObject.getString("images")
                    val licensors = randomAnimeObject.getString("licensors")
                    val malId = randomAnimeObject.getString("malId")
                    val members = randomAnimeObject.getString("members")
                    val popularity = randomAnimeObject.getString("popularity")
                    val producers = randomAnimeObject.getString("producers")
                    val rank = randomAnimeObject.getString("rank")
                    val rating = randomAnimeObject.getString("rating")
                    val score = randomAnimeObject.getString("score")
                    val scoredBy = randomAnimeObject.getString("scoredBy")
                    val season = randomAnimeObject.getString("season")
                    val source = randomAnimeObject.getString("source")
                    val status = randomAnimeObject.getString("status")
                    val studios = randomAnimeObject.getString("studios")
                    val synopsis = randomAnimeObject.getString("synopsis")
                    val themes = randomAnimeObject.getString("themes")
                    val title = randomAnimeObject.getString("title")
                    val titleEnglish = randomAnimeObject.getString("titleEnglish")
                    val titleJapanese = randomAnimeObject.getString("titleJapanese")
                    val titleSynonyms = randomAnimeObject.getString("titleSynonyms")
                    val titles = randomAnimeObject.getString("titles")
                    val trailer = randomAnimeObject.getString("trailer")
                    val type = randomAnimeObject.getString("type")
                    val malUrl = randomAnimeObject.getString("malUrl")
                    val year = randomAnimeObject.getString("year")





                    fetchedRandomAnime.add(RandomAnime(

                    ))
                }
                callback(fetchedRandomAnime)
            }
        }
    }

}