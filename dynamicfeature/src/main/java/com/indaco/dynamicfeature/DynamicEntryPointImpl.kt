package com.indaco.dynamicfeature

import android.content.Context
import android.content.Intent
import com.google.auto.service.AutoService
import com.indaco.data.launcher.DynamicDestination
import com.indaco.data.launcher.DynamicEntryPoint


@AutoService(DynamicEntryPoint::class)
class DynamicFeaturePointImpl: DynamicEntryPoint {
    override fun getLaunchIntent(
        destination: DynamicDestination,
        context: Context,
        extras: Intent?
    ): Intent {
        return Intent(
            context,
            when (destination) {
                DynamicDestination.MainActivity -> DynamicActivity::class.java
            }
        ).apply { extras?.let { putExtras(it) } }
    }
}