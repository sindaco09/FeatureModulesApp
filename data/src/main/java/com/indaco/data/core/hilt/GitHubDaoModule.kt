package com.indaco.data.core.hilt

import com.indaco.data.core.room.AppDatabase
import com.indaco.data.storage.dao.GitHubDao
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