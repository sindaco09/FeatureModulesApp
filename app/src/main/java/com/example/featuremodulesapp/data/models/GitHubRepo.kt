package com.example.featuremodulesapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "github_repos")
data class GitHubRepo(@PrimaryKey val id: String, val name: String)
