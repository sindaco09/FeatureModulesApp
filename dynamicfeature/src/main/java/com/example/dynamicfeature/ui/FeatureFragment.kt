package com.example.dynamicfeature.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dynamicfeature.R
import com.example.dynamicfeature.core.hilt.Injector
import com.example.dynamicfeature.databinding.FragmentFeatureBinding
import com.example.featuremodulesapp.core.hilt.viewmodel.ViewModelFactory
import com.example.featuremodulesapp.data.models.github.GitHubRepo
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
 * --------------------------------------
 * static variables in a shared repository do not span across modules. MainRepository.username
 * can be set here. but when returning to :app module and return back here to :dynamicfeature,
 * the variable MainRepository.username returns to 'null'
*/
class FeatureFragment : Fragment(R.layout.fragment_feature) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: FeatureViewModel

    private val binding: FragmentFeatureBinding by viewBinding(FragmentFeatureBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Injector.from(requireContext()).inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)[FeatureViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initFeatureData()

        initMainData()

        initReposNetworkCall()
    }

    @SuppressLint("SetTextI18n")
    private fun initFeatureData() {
        with(binding) {
            viewModel.token.observe(viewLifecycleOwner) { tokenTv.text = "Token: $it" }

            submitFeatureToken.setOnClickListener { viewModel.setToken(featureTokenEt.text.toString()) }

            tokenTv.text = "Token: ${viewModel.getToken()}"
        }
    }

    // Test app/../MainRepository. does static variables work across modules?
    // No, static variables lose value when exiting the module
    @SuppressLint("SetTextI18n")
    private fun initMainData() {
        with(binding) {
            viewModel.username.observe(viewLifecycleOwner) { usernameTv.text = "Username: $it" }

            submitUsername.setOnClickListener { viewModel.setUserName(usernameEt.text.toString()) }

            usernameTv.text = "Username: ${viewModel.getUserName()}"
        }
    }

    private fun initReposNetworkCall() {
        viewModel.getRepos().observe(viewLifecycleOwner) {
            if (it.isSuccessful)
                setListView(it.body())
            else {
                Toast.makeText(requireContext(),"error!: {${it.code()}: ${it.message()}}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setListView(list: List<GitHubRepo>?) {
        if (!list.isNullOrEmpty()) {
            val repositories = list.map { it.name }
            binding.listView.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, repositories)
        }
    }
}