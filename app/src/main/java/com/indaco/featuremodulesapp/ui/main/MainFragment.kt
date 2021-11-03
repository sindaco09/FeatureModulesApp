package com.indaco.featuremodulesapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.indaco.featuremodulesapp.R
import com.indaco.featuremodulesapp.databinding.FragmentMainBinding
import com.indaco.featuremodulesapp.util.viewBinding
import com.indaco.instantlibrary.InstantActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment: Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        with(binding) {

            instantFeatureBtn.setOnClickListener {
                requireActivity().startActivity(Intent(requireContext(), InstantActivity::class.java))
            }

            authFragmentBtn.setOnClickListener {
                findNavController().navigate(MainFragmentDirections.goToAuthGraph())
            }

        }
    }
}