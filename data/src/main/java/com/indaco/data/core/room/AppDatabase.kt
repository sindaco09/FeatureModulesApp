package com.indaco.data.core.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.indaco.data.models.auth.User
import com.indaco.data.models.github.GitHubRepo
import com.indaco.data.storage.dao.GitHubDao
import com.indaco.data.storage.dao.UserDao

@Database(entities = [GitHubRepo::class, User::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun provideGitHubDao(): GitHubDao
    abstract fun provideUserDao(): UserDao
}