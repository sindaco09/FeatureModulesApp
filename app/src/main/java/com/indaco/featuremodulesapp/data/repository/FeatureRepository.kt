package com.indaco.featuremodulesapp.data.repository

import com.indaco.data.models.github.GitHubRepo
import com.indaco.featuremodulesapp.data.network.GitHubApi
import com.indaco.featuremodulesapp.data.storage.cache.GitHubCache
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FeatureRepository @Inject constructor(
    private val gitHubApi: GitHubApi,
    private val gitHubCache: GitHubCache
) {

    // Test static variable persistance across modules
    var token: String? = null

    // test Storage(Room DB) & Network(Retrofit/OkHttp) modules in feature module
    suspend fun getRepos(): Flow<Response<List<GitHubRepo>?>> {
        val cached = gitHubCache.getGitHubRepos()
        return if (!cached.isNullOrEmpty())
            flowOf(Response.success(cached))
        else
            flowOf(
                gitHubApi.getGithubRepos().also {
                    if (it.isSuccessful)
                        gitHubCache.saveGitHubRepos(it.body())
                }
            )
    }
}