package com.animeez.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.animeez.viewModels.AnimeDetailsViewModel
import com.example.animeez.databinding.FragmentAnimeDetailsBinding

class AnimeDetailsFragment : Fragment() {


    private lateinit var viewModel: AnimeDetailsViewModel
    private var _binding: FragmentAnimeDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[AnimeDetailsViewModel::class.java]
        _binding = FragmentAnimeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}