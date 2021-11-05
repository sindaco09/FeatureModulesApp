package com.indaco.dynamicfeature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.indaco.featuremodulesapp.util.AppUtil

class DynamicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic)
        Log.d("TAG", AppUtil.print())
    }
}