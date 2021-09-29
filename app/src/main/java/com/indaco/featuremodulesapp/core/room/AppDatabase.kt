package com.indaco.featuremodulesapp.core.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.indaco.featuremodulesapp.data.models.auth.User
import com.indaco.featuremodulesapp.data.models.github.GitHubRepo
import com.indaco.featuremodulesapp.data.storage.dao.GitHubDao
import com.indaco.featuremodulesapp.data.storage.dao.UserDao

@Database(entities = [GitHubRepo::class, User::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun provideGitHubDao(): GitHubDao
    abstract fun provideUserDao(): UserDao
}