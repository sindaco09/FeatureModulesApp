package com.example.dynamicfeature.data.storage

import com.example.dynamicfeature.data.models.GitHubRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubCache @Inject constructor(private val gitHubDao: GitHubDao) {

//    suspend fun getGitHubRepos(): List<GitHubRepo>? = gitHubDao.getGitRepositories()
//
//    fun saveGitHubRepos(list: List<GitHubRepo>?) { gitHubDao.updateGitRepositories(list) }
}