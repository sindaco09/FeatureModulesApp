package com.example.dynamicfeature.data.network

import com.example.dynamicfeature.data.models.GitHubRepo
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FeatureApi @Inject constructor(private val featureApiService: FeatureApiService) {

    fun getGithubRepos(): Response<List<GitHubRepo>> = featureApiService.getListRepos("sindaco09").execute()
}
