package com.animeez.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.animeez.models.recommendations.animeRecommendations.AnimeRecommendation
import androidx.recyclerview.widget.RecyclerView
import com.animeez.models.recommendations.animeRecommendations.Images
import com.example.animeez.databinding.ShowItemBinding
import com.squareup.picasso.Picasso


class AnimeRecommendationAdapter(private val recommendations: List<AnimeRecommendation>):
    RecyclerView.Adapter<AnimeRecommendationAdapter.AnimeRecommendationsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeRecommendationAdapter.AnimeRecommendationsViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ShowItemBinding.inflate(inflater, parent, false)
        val vh = AnimeRecommendationAdapter.AnimeRecommendationsViewHolder(binding)
        return vh
    }
    override fun onBindViewHolder(holder: AnimeRecommendationAdapter.AnimeRecommendationsViewHolder, position: Int) {
        val recommendations = recommendations[position]
        //Picasso.get().load().into(holder.binding.animeImage)
    }
    override fun getItemCount(): Int {
        return recommendations.size
    }


    //Kotlin file for show_item.xml
//1 single prop - root view element
    class AnimeRecommendationsViewHolder(val binding: ShowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}