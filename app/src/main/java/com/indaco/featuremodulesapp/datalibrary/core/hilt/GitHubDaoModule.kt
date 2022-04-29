package com.indaco.featuremodulesapp.datalibrary.core.hilt

import com.indaco.featuremodulesapp.datalibrary.core.room.AppDatabase
import com.indaco.featuremodulesapp.datalibrary.dao.GitHubDao
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