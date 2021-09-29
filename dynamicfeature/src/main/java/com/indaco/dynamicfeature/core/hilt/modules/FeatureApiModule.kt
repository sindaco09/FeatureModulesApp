package com.indaco.dynamicfeature.core.hilt.modules

import com.indaco.dynamicfeature.data.network.GitHubApi
import com.indaco.dynamicfeature.data.network.GitHubApiService
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