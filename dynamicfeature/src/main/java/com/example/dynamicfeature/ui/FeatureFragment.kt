package com.example.dynamicfeature.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dynamicfeature.R
import com.example.dynamicfeature.core.hilt.Injector
import com.example.dynamicfeature.databinding.ActivityFeatureBinding
import com.example.featuremodulesapp.core.hilt.viewmodel.ViewModelFactory
import com.example.featuremodulesapp.util.viewBinding
import javax.inject.Inject

/*
 * Below either method of injecting ViewModel works
 * Use (1) to use a shared viewmodel between fragments/activities
 * (1) @Inject lateinit var viewModelFactory: ViewModelFactory
 * .. viewModel = ViewModelProvider(this, viewModelFactory)[FeatureViewModel::class.java]
 *
 * Use (2) to use a private single-use viewModel (like for a fragment lifecycle)
 * (2) @Inject lateinit var viewModel: FeatureViewModel
*/
class FeatureFragment : Fragment(R.layout.activity_feature) {

//    @Inject lateinit var viewModel: FeatureViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: FeatureViewModel

    private val binding: ActivityFeatureBinding by viewBinding(ActivityFeatureBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Injector.from(requireContext()).inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)[FeatureViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    @SuppressLint("SetTextI18n")
    private fun init() {
        with(binding) {
            viewModel.token.observe(viewLifecycleOwner) { tokenTv.text = "Token: $it" }

            submitToken.setOnClickListener { viewModel.setToken(tokenEt.text.toString()) }

            getToken.setOnClickListener {
                tokenTv.text = viewModel.printPrettyToken()
            }
        }
    }
}