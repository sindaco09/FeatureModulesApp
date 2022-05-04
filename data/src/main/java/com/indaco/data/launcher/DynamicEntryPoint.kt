package com.indaco.data.launcher

import android.content.Context
import android.content.Intent

interface DynamicEntryPoint {
    fun getLaunchIntent(
        destination: DynamicDestination,
        context: Context,
        extras: Intent? = null
    ): Intent
}