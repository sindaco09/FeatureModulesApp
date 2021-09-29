package com.indaco.dynamicfeature.core.hilt

import android.content.Context
import com.indaco.featuremodulesapp.core.hilt.dependencies.DynamicFeatureDependencies
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