package com.animeez.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.animeez.*
import com.animeez.adapters.AnimeScheduleAdapter
import com.animeez.adapters.MagazineAdapter
import com.animeez.adapters.RandomAnimeAdapter
import com.animeez.viewModels.MainViewModel
import com.example.animeez.databinding.FragmentMainBinding
import kotlinx.coroutines.launch

class MainFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    init {
        val prefs = requireContext().getSharedPreferences("file1", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putBoolean("first_time",false)
        editor.apply()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let{
            val email = it.getString("email", ARG_USER_EMAIL)
            val userName = it.getString(ARG_USER_USERNAME)
            val password = it.getString("password", ARG_USER_PASSWORD)
            val newUserEmail = it.getString("new user email", ARG_NEW_USER_EMAIL)
            val newUserUserName = it.getString("new user userName", ARG_NEW_USER_USERNAME)
            val newUserPassword = it.getString("new user password", ARG_NEW_USER_PASSWORD)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Create a Main ViewModel for this main fragment:
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO: must use the adapters in here:
        //TODO: use mainViewModel HERE:
        viewModel.greet.observe(viewLifecycleOwner){greet ->
            Toast.makeText(requireContext(), greet, Toast.LENGTH_SHORT).show()
        }
        viewModel.schedules.observe(viewLifecycleOwner) {
            binding.mainFragmentRvAiringSchedule.adapter = AnimeScheduleAdapter(it)
            binding.mainFragmentRvAiringSchedule.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, true)
        }
        viewModel.randomAnime.observe(viewLifecycleOwner){
            binding.mainFragmentRvRandomAnime.adapter = RandomAnimeAdapter(it)
            binding.mainFragmentRvRandomAnime.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, true)
            }
        viewModel.magazines.observe(viewLifecycleOwner){
            binding.mainFragmentRvMagazines.adapter = MagazineAdapter(it)
            binding.mainFragmentRvMagazines.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, true)
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}