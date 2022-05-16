package com.indaco.featuremodulesapp.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amplitude.api.Amplitude
import com.google.android.gms.instantapps.InstantApps
import com.indaco.featuremodulesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        Amplitude.getInstance().logEvent("MainActivity launch");


    }
}