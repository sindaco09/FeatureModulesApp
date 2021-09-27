package com.example.dynamicfeature.data

import com.example.dynamicfeature.data.models.GitHubRepo
import com.example.dynamicfeature.data.network.GitHubApi
import com.example.dynamicfeature.data.storage.GitHubCache
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FeatureRepository @Inject constructor(
    private val gitHubApi: GitHubApi
) {

    var token: String? = null

//    suspend fun getRepos(): Flow<Response<List<GitHubRepo>>> {
//        val cached = gitHubCache.getGitHubRepos()
//        return if (!cached.isNullOrEmpty())
//            flowOf(Response.success(cached))
//        else
//            flow {
//                gitHubApi.getGithubRepos().also {
//                    if (it.isSuccessful) gitHubCache.saveGitHubRepos(it.body())
//                }
//            }
//    }

    fun getRepos() = gitHubApi.getGithubRepos()
}