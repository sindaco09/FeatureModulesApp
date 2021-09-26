package com.example.dynamicfeature.core.hilt

import android.content.Context
import com.example.featuremodulesapp.core.hilt.dependencies.DynamicFeatureDependencies
import dagger.hilt.android.EntryPointAccessors

object Injector {

    fun from(context: Context): DynamicFeatureComponent {
        return DaggerDynamicFeatureComponent
            .builder()
            .context(context)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    context.applicationContext,
                    DynamicFeatureDependencies::class.java
                )
            )
            .build()
    }
}