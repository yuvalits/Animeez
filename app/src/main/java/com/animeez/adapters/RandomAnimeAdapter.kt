package com.animeez.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.animeez.models.randomAnime.RandomAnime
import com.example.animeez.databinding.MovieItemBinding


class RandomAnimeAdapter(private val randomAnimes: List<RandomAnime>):
    RecyclerView.Adapter<RandomAnimeAdapter.MovieViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = MovieItemBinding.inflate(inflater, parent, false)
        return MovieViewHolder(binding)
    }

    //display the info (data classes / API) in the ViewHolder's Views
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = randomAnimes[position]
        //Picasso.get().load().into(holder.binding.movieImage)
    }
    //how many items do we have to display
    override fun getItemCount(): Int {
        return randomAnimes.size
    }


    //Kotlin file for Movie_item.xml - nested class
    //1 single prop - root view element
    class MovieViewHolder(val binding: MovieItemBinding):
        RecyclerView.ViewHolder(binding.root){

    }

}






















