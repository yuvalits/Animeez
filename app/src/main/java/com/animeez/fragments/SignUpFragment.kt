package com.animeez.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.animeez.ARG_NEW_USER_EMAIL
import com.animeez.ARG_NEW_USER_PASSWORD
import com.animeez.ARG_NEW_USER_USERNAME
import com.example.animeez.R
import com.example.animeez.databinding.FragmentSignupBinding


class SignUpFragment : Fragment() {

    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ARG_NEW_USER_EMAIL = binding.signupPageEmailInput.text.toString()
        ARG_NEW_USER_USERNAME = binding.signupPageUsernameInput.text.toString()
        ARG_NEW_USER_PASSWORD = binding.signupPagePasswordInput.text.toString()

        binding.signupPageSignupBtn.setOnClickListener {
            val bundle = Bundle()
            //TODO: check data is valid before being bundled
            bundle.putString("new user email", ARG_NEW_USER_EMAIL)
            bundle.putString("new user userName", ARG_NEW_USER_USERNAME)
            bundle.putString("new user password", ARG_NEW_USER_PASSWORD)
            findNavController().navigate(R.id.action_signUpFragment_to_mainFragment, bundle)
        }
        binding.signupPageBackBtn.setOnClickListener{
            findNavController().navigate(R.id.action_signUpFragment_to_LogInFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}