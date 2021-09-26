package com.example.dynamicfeature.data.network

import com.example.dynamicfeature.data.models.GitHubRepo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FeatureApiService {
    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    @GET(BASE_URL + "users/{user}/repos")
    fun getListRepos(@Path("user") user: String): Call<List<GitHubRepo>>
}