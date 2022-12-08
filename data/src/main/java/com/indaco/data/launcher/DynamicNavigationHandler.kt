package com.indaco.data.launcher

import android.content.Context
import android.content.Intent
import java.lang.RuntimeException
import java.util.*

object DynamicNavigationHandler {

    private fun dynamicLauncherIntent(c: Context, destination: DynamicDestination): Intent {
        return try {
            val service = ServiceLoader.load(DynamicEntryPoint::class.java).first()
            System.console()?.printf("dynamicLauncherIntent: FOUND LOADER")
            service.getLaunchIntent(destination,c)
        } catch (e: Exception) {
            System.console()?.printf("dynamicLauncherIntent: EXCEPTION: $e")
            Intent().setClassName(c.packageName, "com.indaco.dynamicfeature.DynamicActivity")
        }
    }

    fun startDynamicActivity(c: Context) = c.startActivity(dynamicLauncherIntent(c, DynamicDestination.MainActivity))
}