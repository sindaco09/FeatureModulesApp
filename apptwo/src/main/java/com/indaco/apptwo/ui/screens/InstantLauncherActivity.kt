package com.indaco.apptwo.ui.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import com.amplitude.api.Amplitude
import com.indaco.data.launcher.DynamicNavigationHandler
import com.indaco.featuremodulesapp.R

class InstantLauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instant_launcher)
//        Amplitude.getInstance().logEvent("InstantLauncherActivity launch");

        DynamicNavigationHandler.startDynamicActivity(this)
        finish()
    }
}