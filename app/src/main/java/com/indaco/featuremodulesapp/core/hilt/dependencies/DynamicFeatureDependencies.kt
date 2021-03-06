package com.indaco.featuremodulesapp.core.hilt.dependencies

import com.indaco.featuremodulesapp.core.hilt.IODispatcher
import com.indaco.featuremodulesapp.core.room.AppDatabase
import com.indaco.featuremodulesapp.data.storage.dao.GitHubDao
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit

// EntryPoints are needed for Modules (like [:dynamicfeature]) to communicate with for hilt injections
// Below are dependencies needed by [:dynamicfeature] but defined in [:app]
@EntryPoint
@InstallIn(SingletonComponent::class)
interface DynamicFeatureDependencies {

    @IODispatcher
    fun dispatcher(): CoroutineDispatcher

    fun retrofit(): Retrofit

    fun gitHubDao(): GitHubDao

    fun db(): AppDatabase
}