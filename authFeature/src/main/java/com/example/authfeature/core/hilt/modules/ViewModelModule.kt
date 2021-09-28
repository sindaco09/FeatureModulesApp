package com.example.authfeature.core.hilt.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.authfeature.ui.AuthViewModel
import com.example.featuremodulesapp.core.hilt.viewmodel.ViewModelFactory
import com.example.featuremodulesapp.core.hilt.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

/**
 * This module is for injecting one-time-use viewmodels instead of making them singletons.
 * It allows for repository injection while tying the viewmodel to the owner lifecycle.
 * Also allows for shared viewmodels between activity and fragments.
 *
 * ex:
 * @Inject lateinit var viewModelFactory: ViewModelFactory
 * private lateinit var viewModel: RemoteLoginViewModel
 * viewModel = ViewModelProvider(requireActivity(), viewModelFactory)[RemoteLoginViewModel::class.java]
 */
@InstallIn(SingletonComponent::class)
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun provideAuthViewModel(viewModel: AuthViewModel): ViewModel
}