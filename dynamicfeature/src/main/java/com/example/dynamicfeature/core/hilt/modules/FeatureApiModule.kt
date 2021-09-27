package com.example.dynamicfeature.core.hilt.modules

import com.example.dynamicfeature.data.network.GitHubApi
import com.example.dynamicfeature.data.network.GitHubApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class FeatureApiModule {

    @Provides
    fun provideFeatureApi(retrofit: Retrofit) =
        GitHubApi(retrofit.create(GitHubApiService::class.java))
}