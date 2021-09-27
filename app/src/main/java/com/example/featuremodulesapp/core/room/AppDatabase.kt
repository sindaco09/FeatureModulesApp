package com.example.featuremodulesapp.core.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.featuremodulesapp.data.models.GitHubRepo
import com.example.featuremodulesapp.data.storage.dao.GitHubDao

@Database(entities = [GitHubRepo::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun provideGitHubDao(): GitHubDao
}