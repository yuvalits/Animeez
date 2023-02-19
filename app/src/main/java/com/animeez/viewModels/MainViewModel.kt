package com.animeez.viewModels

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.animeez.models.genres.Genre
import com.animeez.models.magazines.Magazine
import com.animeez.models.randomAnime.RandomAnime
import com.animeez.models.recommendations.animeRecommendations.AnimeRecommendation
import com.animeez.models.recommendations.mangaRecommendations.MangaRecommendation
import com.animeez.models.schedules.Schedule
import com.animeez.services.*
import kotlinx.coroutines.*


@OptIn(DelicateCoroutinesApi::class)
class MainViewModel(application: Application) : AndroidViewModel(application) {

    //exposure live data for the View
    private val _greet = MutableLiveData<String>()
    private val _magazines = MutableLiveData<List<Magazine>>()
    private val _genres = MutableLiveData<List<Genre>>()
    private val _schedules = MutableLiveData<List<Schedule>>()
    private val _randomAnime = MutableLiveData<List<RandomAnime>>()
    private val _animeRecommendations = MutableLiveData<List<AnimeRecommendation>>()
    private val _mangaRecommendations = MutableLiveData<List<MangaRecommendation>>()

    //exposure liveData to the view as liveData
    val greet: LiveData<String> = _greet
    val magazines: LiveData<List<Magazine>> = _magazines
    val genres: LiveData<List<Genre>> = _genres
    val schedules: LiveData<List<Schedule>> = _schedules
    val randomAnime: LiveData<List<RandomAnime>> = _randomAnime
    val animeRecommendation: LiveData<List<AnimeRecommendation>> = _animeRecommendations
    val mangaRecommendation: LiveData<List<MangaRecommendation>> = _mangaRecommendations

    init {

        val prefs = application.getSharedPreferences("file1", Context.MODE_PRIVATE)
        val firstTime = prefs.getBoolean("first_time", true)
        if (firstTime){
            prefs.edit().putBoolean("first_time",false).apply()
        }

        GlobalScope.launch(Dispatchers.IO) {
            launch {
                MagazinesService.fetchMagazines {
                    GlobalScope.launch(Dispatchers.Main) {
                        _magazines.postValue(it)
                    }
                }
            }
            launch {
                GenresService.fetchAnimeGenres {
                    GlobalScope.launch(Dispatchers.Main) {
                        _genres.postValue(it)
                    }
                }
            }
            launch {
                SchedulesServices.fetchAnimeSchedule {
                    GlobalScope.launch(Dispatchers.Main) {
                        _schedules.postValue(it)
                    }
                }
            }
            launch {
                RandomAnimeServices.fetchRandomAnime {
                    RandomAnimeServices.fetchRandomAnime {
                        GlobalScope.launch(Dispatchers.Main) {
                            _randomAnime.postValue(it)
                        }
                    }
                }
            }
            launch {
                AnimeRecommendationsService.fetchAnimeRecommendations {
                    GlobalScope.launch(Dispatchers.Main) {
                        _animeRecommendations.postValue(it)
                    }
                }
            }
            launch {
                MangaRecommendationsService.fetchMangaRecommendations {
                    GlobalScope.launch(Dispatchers.Main) {
                        _mangaRecommendations.postValue(it)
                    }
                }
            }
        }
        viewModelScope.launch(Dispatchers.IO) {
            val magazines = MagazinesService.fetchMagazines {}
            val genres = GenresService.fetchAnimeGenres {}
            val schedules = SchedulesServices.fetchAnimeSchedule {}
            val randomAnimes = RandomAnimeServices.fetchRandomAnime {}
            val animeRecommendations = AnimeRecommendationsService.fetchAnimeRecommendations {}
            val mangaRecommendations = MangaRecommendationsService.fetchMangaRecommendations {}
            launch(Dispatchers.Main) {
                print(magazines)
                print(genres)
                print(schedules)
                print(randomAnimes)
                print(animeRecommendations)
                print(mangaRecommendations)
            }
        }


    }






    //TODO:(2) exposure the data-class items in the viewModel


    //TODO:(3) exposure data class functions in the viewModel

}
