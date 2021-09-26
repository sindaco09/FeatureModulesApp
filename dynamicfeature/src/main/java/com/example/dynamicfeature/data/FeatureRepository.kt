package com.example.dynamicfeature.data

import com.example.dynamicfeature.data.network.FeatureApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FeatureRepository @Inject constructor(private val featureApi: FeatureApi) {
    var token: String? = null

    suspend fun getRepos() = featureApi.getGithubRepos()
}