package com.indaco.apptwo

import android.app.Application
import com.amplitude.api.Amplitude
import com.indaco.data.BuildConfig
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this)
        Amplitude.getInstance().initialize(this, BuildConfig.amplitudeApiKey)
            .enableForegroundTracking(this)
    }

}