package com.example.authfeature.core.hilt

import android.content.Context
import com.example.featuremodulesapp.core.hilt.dependencies.AuthFeatureDependencies
import dagger.hilt.android.EntryPointAccessors

object Injector {
    fun from(context: Context): AuthFeatureComponent {
        return DaggerAuthFeatureComponent
            .builder()
            .context(context)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    context.applicationContext,
                    AuthFeatureDependencies::class.java
                )
            )
            .build()
    }
}