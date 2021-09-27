package com.example.featuremodulesapp.core.hilt.modules.storage

import com.example.featuremodulesapp.core.room.AppDatabase
import com.example.featuremodulesapp.data.storage.dao.GitHubDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class GitHubDaoModule {
    @Provides
    fun provideGitHubDao(db: AppDatabase): GitHubDao = db.provideGitHubDao()
}