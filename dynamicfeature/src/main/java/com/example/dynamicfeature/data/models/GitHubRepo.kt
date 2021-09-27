package com.example.dynamicfeature.data.models

import androidx.room.Entity

@Entity(tableName = "github_repos")
data class GitHubRepo(val id: String, val name: String)
