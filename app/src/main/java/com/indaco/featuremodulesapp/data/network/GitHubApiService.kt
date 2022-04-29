package com.indaco.featuremodulesapp.data.network

import com.indaco.featuremodulesapp.datalibrary.models.github.GitHubRepo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApiService {
    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    @GET(BASE_URL + "users/{user}/repos")
    fun getListRepos(@Path("user") user: String): Call<List<GitHubRepo>>
}