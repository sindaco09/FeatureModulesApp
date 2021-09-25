package com.example.featuremodulesapp.ui.main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.featuremodulesapp.R
import com.example.featuremodulesapp.databinding.ActivityMainBinding
import com.example.featuremodulesapp.ui.secondary.SecondaryActivity
import com.example.featuremodulesapp.util.dynamicPackageName

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