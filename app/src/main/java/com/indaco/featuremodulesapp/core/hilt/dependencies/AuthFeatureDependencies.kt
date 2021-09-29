package com.indaco.featuremodulesapp.core.hilt.dependencies

import com.indaco.featuremodulesapp.core.hilt.IODispatcher
import com.indaco.featuremodulesapp.core.room.AppDatabase
import com.indaco.featuremodulesapp.data.storage.dao.UserDao
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@EntryPoint
@InstallIn(SingletonComponent::class)
interface AuthFeatureDependencies {

    @IODispatcher
    fun dispatcher(): CoroutineDispatcher

    fun userDao(): UserDao

    fun db(): AppDatabase
}