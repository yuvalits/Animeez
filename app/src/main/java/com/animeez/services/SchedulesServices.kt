package com.animeez.services

import com.animeez.JIKAN_WEEKLY_SCHEDULE
import com.animeez.models.schedules.*
import com.animeez.utils.IO
import com.google.gson.annotations.SerializedName
import org.json.JSONObject

class SchedulesServices {
    companion object{
        fun fetchAnimeSchedule(callback: (schedules: List<Schedule>)-> Unit) {
            IO.fetchFromUrl(JIKAN_WEEKLY_SCHEDULE) { receivedJson ->
                val json = JSONObject(receivedJson) //casting for us using this class
                val resultsArray = json.getJSONArray("results") //get the json as an array
                val fetchedSchedule = mutableListOf<Schedule>()


                for (i in 0 until resultsArray.length()) {
                    val scheduleObject = resultsArray.getJSONObject(i)
                    val movieId = scheduleObject.getString("movieId")

                    val aired = scheduleObject.getString("aired")
                    val airing = scheduleObject.getString("airing")
                    val approved = scheduleObject.getString("approved")
                    val background = scheduleObject.getString("background")
                    val broadcast = scheduleObject.getString("broadcast")
                    val demographics = scheduleObject.getString("demographics")
                    val duration = scheduleObject.getString("duration")
                    val episodes = scheduleObject.getString("episodes")
                    val explicitGenres = scheduleObject.getString("explicitGenres")
                    val favorites = scheduleObject.getString("favorites")
                    val genres = scheduleObject.getString("genres")
                    val images = scheduleObject.getString("images")
                    val licensors = scheduleObject.getString("licensors")
                    val malId = scheduleObject.getString("malId")
                    val members = scheduleObject.getString("members")
                    val popularity = scheduleObject.getString("popularity")
                    val producers = scheduleObject.getString("producers")
                    val rank = scheduleObject.getString("rank")
                    val rating = scheduleObject.getString("rating")
                    val score = scheduleObject.getString("score")
                    val scoredBy = scheduleObject.getString("scoredBy")
                    val season = scheduleObject.getString("season")
                    val source = scheduleObject.getString("source")
                    val status = scheduleObject.getString("status")
                    val studios = scheduleObject.getString("studios")
                    val synopsis = scheduleObject.getString("synopsis")
                    val themes = scheduleObject.getString("themes")
                    val title = scheduleObject.getString("title")
                    val titleEnglish = scheduleObject.getString("titleEnglish")
                    val titleJapanese = scheduleObject.getString("titleJapanese")
                    val titleSynonyms = scheduleObject.getString("titleSynonyms")
                    val titles = scheduleObject.getString("titles")
                    val trailer = scheduleObject.getString("trailer")
                    val type = scheduleObject.getString("type")
                    val malUrl = scheduleObject.getString("malUrl")
                    val year = scheduleObject.getString("year")




                    fetchedSchedule.add(Schedule(
                        title =
                    ))
                }
                callback(fetchedSchedule)
            }
        }
    }
}