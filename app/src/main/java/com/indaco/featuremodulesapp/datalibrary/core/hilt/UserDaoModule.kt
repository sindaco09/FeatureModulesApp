package com.indaco.featuremodulesapp.datalibrary.core.hilt

import com.indaco.featuremodulesapp.datalibrary.core.room.AppDatabase
import com.indaco.featuremodulesapp.datalibrary.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class UserDaoModule {
    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.provideUserDao()
}