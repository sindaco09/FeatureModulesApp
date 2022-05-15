package com.indaco.apptwo.util

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.indaco.data.launcher.DynamicNavigationHandler
import com.indaco.featuremodulesapp.R

class InstantLauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instant_launcher)

        DynamicNavigationHandler.startDynamicActivity(this)
    }
}