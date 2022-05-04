package com.indaco.data.launcher

import android.content.Context
import android.content.Intent
import java.util.*

object DynamicNavigationHandler {

    private fun dynamicLauncherIntent(c: Context, destination: DynamicDestination): Intent {
        val service = ServiceLoader.load(DynamicEntryPoint::class.java).first()
        return service.getLaunchIntent(destination,c)
    }

    fun startDynamicActivity(c: Context) = c.startActivity(dynamicLauncherIntent(c, DynamicDestination.MainActivity))
}