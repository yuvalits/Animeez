package com.animeez.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.animeez.ARG_USER_EMAIL
import com.animeez.ARG_USER_PASSWORD
import com.example.animeez.R
import com.example.animeez.databinding.FragmentLoginBinding

class LogInFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ARG_USER_EMAIL = binding.loginFragmentEtEmail.text.toString()
        ARG_USER_PASSWORD = binding.loginFragmentEtPassword.text.toString()

        binding.loginFragmentBtnNewAccount.setOnClickListener {
            findNavController().navigate(R.id.action_LogInFragment_to_signUpFragment)
        }
        binding.loginFragmentBtnEnter.setOnClickListener{
            val bundle = Bundle()
            //TODO: check the input is valid before being bundled.
                bundle.putString("email" , ARG_USER_EMAIL)
                bundle.putString("password", ARG_USER_PASSWORD)
            findNavController().navigate(R.id.action_LogInFragment_to_mainFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}