package com.example.dynamicfeature.core.hilt

import android.content.Context
import com.example.dynamicfeature.core.hilt.modules.FeatureApiModule
import com.example.dynamicfeature.core.hilt.modules.ViewModelModule
import com.example.dynamicfeature.ui.FeatureActivity
import com.example.dynamicfeature.ui.FeatureFragment
import com.example.featuremodulesapp.core.hilt.dependencies.DynamicFeatureDependencies
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [DynamicFeatureDependencies::class],
    modules = [ViewModelModule::class, FeatureApiModule::class]
)
interface DynamicFeatureComponent {

    fun inject(fragment: FeatureFragment)
    fun inject(activity: FeatureActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(dependencies: DynamicFeatureDependencies): Builder
        fun build(): DynamicFeatureComponent
    }
}