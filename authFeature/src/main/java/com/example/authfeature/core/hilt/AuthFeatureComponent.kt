package com.example.authfeature.core.hilt

import android.content.Context
import com.example.authfeature.core.hilt.modules.ViewModelModule
import com.example.authfeature.ui.AuthActivity
import com.example.authfeature.ui.AuthFragment
import com.example.featuremodulesapp.core.hilt.dependencies.AuthFeatureDependencies
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AuthFeatureDependencies::class],
    modules = [ViewModelModule::class]
)
interface AuthFeatureComponent {

    fun inject(fragment: AuthFragment)
    fun inject(activity: AuthActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(dependencies: AuthFeatureDependencies): Builder
        fun build(): AuthFeatureComponent
    }
}