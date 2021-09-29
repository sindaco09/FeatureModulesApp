package com.indaco.featuremodulesapp.core.hilt.modules

import com.indaco.featuremodulesapp.core.hilt.IODispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@InstallIn(SingletonComponent::class)
@Module
class DispatcherModule {

    @IODispatcher
    @Provides
    fun providesDispatcher(): CoroutineDispatcher = Dispatchers.IO
}