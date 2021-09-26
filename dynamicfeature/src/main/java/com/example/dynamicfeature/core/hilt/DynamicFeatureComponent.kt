package com.example.dynamicfeature.core.hilt

import android.content.Context
import com.example.dynamicfeature.ui.FeatureActivity
import com.example.dynamicfeature.ui.FeatureFragment
import com.example.featuremodulesapp.core.hilt.featuremodules.DynamicFeatureDependencies
import dagger.BindsInstance
import dagger.Component
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [DynamicFeatureDependencies::class],
    modules = [ViewModelModule::class]
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