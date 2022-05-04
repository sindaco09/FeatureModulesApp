package com.indaco.featuremodulesapp.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.gms.common.wrappers.InstantApps.isInstantApp
import com.indaco.data.launcher.DynamicNavigationHandler
import com.indaco.featuremodulesapp.R
import com.indaco.featuremodulesapp.databinding.FragmentMainBinding
import com.indaco.featuremodulesapp.util.viewBinding
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

            if (isInstantApp(requireContext()))
                featureFragmentBtn.visibility = View.GONE
            else
                featureFragmentBtn.setOnClickListener {
                    findNavController().navigate(MainFragmentDirections.goToFeatureGraph())
                }

            instantLibraryBtn.setOnClickListener {
                DynamicNavigationHandler.startDynamicActivity(requireActivity())
            }

            authFragmentBtn.setOnClickListener {
                findNavController().navigate(MainFragmentDirections.goToAuthGraph())
            }
        }
    }
}