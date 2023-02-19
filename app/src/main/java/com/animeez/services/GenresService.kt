package com.animeez.services

import com.animeez.JIKAN_ANIME_GENRES
import com.animeez.models.genres.Genre
import com.animeez.utils.IO
import org.json.JSONObject

class GenresService {
    companion object{
        fun fetchAnimeGenres(callback: (AnimeGenres: List<Genre>)-> Unit) {
            IO.fetchFromUrl(JIKAN_ANIME_GENRES) { receivedJson ->
                val json = JSONObject(receivedJson) //casting for us using this class
                val resultsArray = json.getJSONArray("results") //get the json as an array
                val fetchedGenres = mutableListOf<Genre>()


                for (i in 0 until resultsArray.length()) {
                    val genreObject = resultsArray.getJSONObject(i)

                    val count = genreObject.getString("count")
                    val malId=genreObject.getString("malId")
                    val name=genreObject.getString("name")
                    val malUrl=genreObject.getString("malUrl")


                    fetchedGenres.add(Genre(count, malId, name, malUrl))
                }
                callback(fetchedGenres)
            }
        }
    }
}