package com.indaco.dynamicfeature.data.network

import com.indaco.featuremodulesapp.data.models.github.GitHubRepo
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubApi @Inject constructor(private val gitHubApiService: GitHubApiService) {

    fun getGithubRepos(): Response<List<GitHubRepo>?> = gitHubApiService.getListRepos("sindaco09").execute()
}
