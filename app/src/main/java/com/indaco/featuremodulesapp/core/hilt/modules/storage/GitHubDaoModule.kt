package com.indaco.featuremodulesapp.core.hilt.modules.storage

import com.indaco.featuremodulesapp.core.room.AppDatabase
import com.indaco.featuremodulesapp.data.storage.dao.GitHubDao
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