package com.indaco.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.indaco.data.models.github.GitHubRepo

@Dao
interface GitHubDao {

    @Query("SELECT * FROM github_repos")
    suspend fun getGitRepositories(): List<GitHubRepo>?

    @Insert(onConflict = REPLACE)
    fun updateGitRepositories(list: List<GitHubRepo>?)
}