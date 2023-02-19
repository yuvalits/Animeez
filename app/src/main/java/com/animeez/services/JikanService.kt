package com.animeez.services

import android.util.Log
import com.animeez.*
import com.animeez.models.magazines.MagazinesResponse
import com.animeez.models.randomAnime.RandomAnimeResponse
import com.animeez.models.recommendations.animeRecommendations.AnimeRecommendationsResponse
import com.animeez.models.recommendations.mangaRecommendations.MangaRecommendationsResponse
import com.animeez.models.schedules.SchedulesResponse
import com.animeez.utils.IO
import okhttp3.Call
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface JikanService {

    companion object {
        fun create(): JikanService {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(logger).build()

            return Retrofit.Builder()
                .client(client)
                .baseUrl(JIKAN_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor(IO.createInterceptor()).build())
                .build()
                .create(JikanService::class.java)
        }
    }

    @GET(JIKAN_MAGAZINES)
    suspend fun getMagazines(@Query("page") page : Int = 1): MagazinesResponse

    @GET(JIKAN_RANDOM_ANIME)
    suspend fun getRandomAnime(): RandomAnimeResponse

    @GET(JIKAN_WEEKLY_SCHEDULE)
    suspend fun getSchedules(): SchedulesResponse

    @GET(JIKAN_ANIME_RECOMMENDATIONS)
    suspend fun getAnimeRecommendations(): AnimeRecommendationsResponse

    @GET(JIKAN_MANGA_RECOMMENDATIONS)
    suspend fun getMangaRecommendations(): MangaRecommendationsResponse



}