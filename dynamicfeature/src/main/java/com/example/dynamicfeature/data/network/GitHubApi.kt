package com.example.dynamicfeature.data.network

import com.example.dynamicfeature.data.models.GitHubRepo
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubApi @Inject constructor(private val gitHubApiService: GitHubApiService) {

    fun getGithubRepos(): Response<List<GitHubRepo>> = gitHubApiService.getListRepos("sindaco09").execute()
}