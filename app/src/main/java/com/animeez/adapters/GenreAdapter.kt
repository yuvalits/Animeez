package com.animeez.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.animeez.models.genres.Genre
import com.example.animeez.databinding.ShowItemBinding
import com.squareup.picasso.Picasso


class GenreAdapter(private val genres: List<Genre>):
    RecyclerView.Adapter<GenreAdapter.GenresViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreAdapter.GenresViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ShowItemBinding.inflate(inflater, parent, false)
        val vh = GenreAdapter.GenresViewHolder(binding)
        return vh
    }
    override fun onBindViewHolder(holder: GenreAdapter.GenresViewHolder, position: Int) {
        val genre = genres[position]
      //  Picasso.get().load().into(holder.binding.animeImage)
    }
    override fun getItemCount(): Int {
        return genres.size
    }


    //Kotlin file for show_item.xml
//1 single prop - root view element
    class GenresViewHolder(val binding: ShowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        }
}
