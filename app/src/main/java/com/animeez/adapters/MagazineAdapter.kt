package com.animeez.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.animeez.models.magazines.Magazine
import com.example.animeez.databinding.ShowItemBinding

class MagazineAdapter(private val magazines: List<Magazine>):
    RecyclerView.Adapter<MagazineAdapter.MagazinesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MagazineAdapter.MagazinesViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ShowItemBinding.inflate(inflater, parent, false)
        val vh = MagazineAdapter.MagazinesViewHolder(binding)
        return vh
    }
    override fun onBindViewHolder(holder: MagazineAdapter.MagazinesViewHolder, position: Int) {
        val magazines = magazines[position]
        //Picasso.get().load().into(holder.binding.animeImage)
    }
    override fun getItemCount(): Int {
        return magazines.size
    }


    //Kotlin file for show_item.xml
//1 single prop - root view element
    class MagazinesViewHolder(val binding: ShowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}