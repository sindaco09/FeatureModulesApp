package com.example.featuremodulesapp.core.hilt.modules.storage

import android.app.Application
import androidx.room.Room
import com.example.featuremodulesapp.core.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppDatabaseModule {
    @Provides
    fun provideDB(application: Application) =
        Room.databaseBuilder(application, AppDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()
}