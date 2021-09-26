package com.example.dynamicfeature.core.hilt.modules

import com.example.dynamicfeature.data.network.FeatureApi
import com.example.dynamicfeature.data.network.FeatureApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class FeatureApiModule {

    @Provides
    fun provideFeatureApi(retrofit: Retrofit) =
        FeatureApi(retrofit.create(FeatureApiService::class.java))
}