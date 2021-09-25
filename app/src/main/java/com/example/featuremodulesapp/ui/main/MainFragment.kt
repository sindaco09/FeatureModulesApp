package com.example.featuremodulesapp.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.featuremodulesapp.R
import com.example.featuremodulesapp.databinding.FragmentMainBinding

class MainFragment: Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        init()
    }

    private fun init() {
        binding.featureBtn.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.goToFeatureGraph())
        }

        binding.secondaryBtn.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.goToSecondary())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}