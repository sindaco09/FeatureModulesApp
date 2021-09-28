package com.example.featuremodulesapp.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.featuremodulesapp.R
import com.example.featuremodulesapp.databinding.FragmentMainBinding
import com.example.featuremodulesapp.util.FeatureActivity
import com.example.featuremodulesapp.util.viewBinding
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
            featureActivityBtn.setOnClickListener {
                MainActivity.launchModuleActivity(requireActivity(), FeatureActivity)
            }

            featureFragmentBtn.setOnClickListener {
                findNavController().navigate(MainFragmentDirections.goToFeatureGraph())
            }

            authFragmentBtn.setOnClickListener {
                findNavController().navigate(MainFragmentDirections.goToAuthGraph())
            }

            secondaryFragmentBtn.setOnClickListener {
                findNavController().navigate(MainFragmentDirections.goToSecondary())
            }
        }
    }
}