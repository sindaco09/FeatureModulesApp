package com.example.dynamicfeature.core.hilt

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.featuremodulesapp.core.hilt.featuremodules.DynamicFeatureDependencies
import com.example.featuremodulesapp.ui.DaggerApp_HiltComponents_SingletonC
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