package com.animeez.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.animeez.models.schedules.Schedule
import com.example.animeez.databinding.ShowItemBinding


class AnimeScheduleAdapter(private val shows: List<Schedule>):
    RecyclerView.Adapter<AnimeScheduleAdapter.AnimeScheduleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeScheduleViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ShowItemBinding.inflate(inflater, parent, false)
        val vh = AnimeScheduleViewHolder(binding)
        return vh
    }
    override fun onBindViewHolder(holder: AnimeScheduleViewHolder, position: Int) {
        val show = shows[position]
        //Picasso.get().load().into(holder.binding.animeImage)
    }
    override fun getItemCount(): Int {
        return shows.size
    }


    //Kotlin file for show_item.xml
//1 single prop - root view element
    class AnimeScheduleViewHolder(val binding: ShowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }


}

