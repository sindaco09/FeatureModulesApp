package com.indaco.featuremodulesapp.ui.main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.indaco.featuremodulesapp.databinding.ActivityMainBinding
import com.indaco.featuremodulesapp.util.dynamicPackageName
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
    }

    companion object {
        fun launchModuleActivity(activity: Activity, className: String) {
            Intent().setClassName(activity.packageName, "$dynamicPackageName.$className")
                .also {
                    activity.startActivity(it)
                }
        }
    }
}