package com.example.authfeature.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.authfeature.R
import com.example.authfeature.core.hilt.Injector
import com.example.authfeature.databinding.FragmentAuthBinding
import com.example.featuremodulesapp.core.hilt.viewmodel.ViewModelFactory
import com.example.featuremodulesapp.util.viewBinding
import javax.inject.Inject

class AuthFragment: Fragment(R.layout.fragment_auth) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: AuthViewModel

    private val binding by viewBinding(FragmentAuthBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Injector.from(requireContext()).inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)[AuthViewModel::class.java]

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