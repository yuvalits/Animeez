package com.animeez.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.animeez.models.recommendations.mangaRecommendations.MangaRecommendation
import androidx.recyclerview.widget.RecyclerView
import com.example.animeez.databinding.ShowItemBinding


class MangaRecommendationsAdapter(private val mangaRecommendations: List<MangaRecommendation>):
    RecyclerView.Adapter<MangaRecommendationsAdapter.MangaRecommendationsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaRecommendationsAdapter.MangaRecommendationsViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ShowItemBinding.inflate(inflater, parent, false)
        val vh = MangaRecommendationsAdapter.MangaRecommendationsViewHolder(binding)
        return vh
    }
    override fun onBindViewHolder(holder: MangaRecommendationsAdapter.MangaRecommendationsViewHolder, position: Int) {
        val mangaRecommendations = mangaRecommendations[position]
        //Picasso.get().load().into(holder.binding.animeImage)
    }
    override fun getItemCount(): Int {
        return mangaRecommendations.size
    }


    //Kotlin file for show_item.xml
//1 single prop - root view element
    class MangaRecommendationsViewHolder(val binding: ShowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}