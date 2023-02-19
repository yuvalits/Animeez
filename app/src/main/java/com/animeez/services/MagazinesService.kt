package com.animeez.services

import com.animeez.JIKAN_MAGAZINES
import com.animeez.models.magazines.Magazine
import com.animeez.utils.IO
import org.json.JSONObject

class MagazinesService {
    companion object{
    fun fetchMagazines(callback: (magazines: List<Magazine>)-> Unit) {
        IO.fetchFromUrl(JIKAN_MAGAZINES) { receivedJson ->
            val json = JSONObject(receivedJson) //casting for us using this class
            val resultsArray = json.getJSONArray("results") //get the json as an array
            val fetchedMovies = mutableListOf<Magazine>()


            for (i in 0 until resultsArray.length()) {
                val magazineObject = resultsArray.getJSONObject(i)

                val count = magazineObject.getString("count")
                val malId = magazineObject.getString("malId")
                val name = magazineObject.getString("name")
                val malUrl = magazineObject.getString("malUrl")


                fetchedMovies.add(Magazine(count, malId, name, malUrl))
            }
            callback(fetchedMovies)
        }
    }
}
}