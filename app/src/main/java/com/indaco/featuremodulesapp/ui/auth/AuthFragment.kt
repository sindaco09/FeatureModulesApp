package com.indaco.featuremodulesapp.ui.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.indaco.featuremodulesapp.R
import com.indaco.featuremodulesapp.core.hilt.viewmodel.ViewModelFactory
import com.indaco.featuremodulesapp.databinding.FragmentAuthBinding
import com.indaco.featuremodulesapp.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AuthFragment: Fragment(R.layout.fragment_auth) {

    private val viewModel: AuthViewModel by activityViewModels()

    private val binding by viewBinding(FragmentAuthBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        viewModel.users.observe(viewLifecycleOwner) {
            var users = ""
            it?.forEach { user -> users +="\n${user.username}" }
            binding.status.text = "Status: $users"
        }

        viewModel.loggedIn.observe(viewLifecycleOwner) {
            binding.status.text = "Status: ${if (it) "is logged in" else "is not logged in"}"
        }

        binding.login.setOnClickListener {
            val username = binding.username.text.toString()
            login(username)
        }

        binding.signup.setOnClickListener {
            signup(binding.username.text.toString())
        }

        viewModel.getUsers()
    }

    private fun signup(username: String) {
        viewModel.addUser(username)
    }

    private fun login(username: String) {
        viewModel.login(username)
    }
}