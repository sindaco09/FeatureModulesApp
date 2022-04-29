package com.indaco.featuremodulesapp.datalibrary.core.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.indaco.featuremodulesapp.datalibrary.models.auth.User
import com.indaco.featuremodulesapp.datalibrary.models.github.GitHubRepo
import com.indaco.featuremodulesapp.datalibrary.dao.GitHubDao
import com.indaco.featuremodulesapp.datalibrary.dao.UserDao

@Database(entities = [GitHubRepo::class, User::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun provideGitHubDao(): GitHubDao
    abstract fun provideUserDao(): UserDao
}