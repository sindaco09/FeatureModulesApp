package com.example.featuremodulesapp.core.hilt.featuremodules

import com.example.featuremodulesapp.core.hilt.IODispatcher
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@EntryPoint
@InstallIn(SingletonComponent::class)
interface DynamicFeatureDependencies {

    @IODispatcher
    fun dispatcher(): CoroutineDispatcher
}