package com.example.featuremodulesapp.core.hilt.featuremodules

import androidx.lifecycle.ViewModelProvider
import com.example.featuremodulesapp.core.hilt.IODispatcher
import com.example.featuremodulesapp.core.hilt.viewmodel.ViewModelFactory
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@EntryPoint
@InstallIn(SingletonComponent::class)
interface DynamicFeatureDependencies {

    @IODispatcher
    fun dispatcher(): CoroutineDispatcher

//    fun viewModelFactory(): ViewModelFactory
}