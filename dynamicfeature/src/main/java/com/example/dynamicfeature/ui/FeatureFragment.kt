package com.example.dynamicfeature.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dynamicfeature.R
import com.example.dynamicfeature.core.hilt.Injector
import com.example.dynamicfeature.data.FeatureRepository
import com.example.dynamicfeature.databinding.ActivityFeatureBinding
import com.example.featuremodulesapp.core.hilt.viewmodel.ViewModelFactory
import com.example.featuremodulesapp.util.viewBinding
import javax.inject.Inject

class FeatureFragment : Fragment(R.layout.activity_feature) {

    @Inject
    lateinit var featureRepository: FeatureRepository

    private val binding: ActivityFeatureBinding by viewBinding(ActivityFeatureBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Injector.from(requireContext()).inject(this)

        Log.d("TAG","repo.token: ${featureRepository.token}")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    @SuppressLint("SetTextI18n")
    private fun init() {

//        viewModel.token.observe(viewLifecycleOwner) {
//            binding.tokenTv.text = "Token: ${viewModel.getToken()}"
//        }

        binding.submitToken.setOnClickListener {
            featureRepository.token = binding.tokenEt.text.toString()
//            viewModel.setToken(binding.tokenEt.text.toString())
        }

        binding.getToken.setOnClickListener {
            val printToken = "Token: ${featureRepository.token}"
            binding.tokenTv.text = printToken
        }
    }
}