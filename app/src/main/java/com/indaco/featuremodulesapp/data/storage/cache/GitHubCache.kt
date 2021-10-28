package com.indaco.featuremodulesapp.data.storage.cache

import com.indaco.data.models.github.GitHubRepo
import com.indaco.data.storage.dao.GitHubDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubCache @Inject constructor(private val gitHubDao: GitHubDao) {

    suspend fun getGitHubRepos(): List<GitHubRepo>? = gitHubDao.getGitRepositories()

    fun saveGitHubRepos(list: List<GitHubRepo>?) { gitHubDao.updateGitRepositories(list) }
}