package com.example.featuremodulesapp.core.hilt.modules.storage

import com.example.featuremodulesapp.core.room.AppDatabase
import com.example.featuremodulesapp.data.storage.dao.UserDao
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