package com.indaco.featuremodulesapp.core.hilt.modules.network

import com.indaco.featuremodulesapp.data.network.GitHubApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class GitHubServiceModule {
    @Provides
    fun provideGitHubService(retrofit: Retrofit): GitHubApiService =
        retrofit.create(GitHubApiService::class.java)
}