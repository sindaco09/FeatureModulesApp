package com.indaco.dynamicfeature.data.storage

import com.indaco.featuremodulesapp.data.models.github.GitHubRepo
import com.indaco.featuremodulesapp.data.storage.dao.GitHubDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubCache @Inject constructor(private val gitHubDao: GitHubDao) {

    suspend fun getGitHubRepos(): List<GitHubRepo>? = gitHubDao.getGitRepositories()

    fun saveGitHubRepos(list: List<GitHubRepo>?) { gitHubDao.updateGitRepositories(list) }
}