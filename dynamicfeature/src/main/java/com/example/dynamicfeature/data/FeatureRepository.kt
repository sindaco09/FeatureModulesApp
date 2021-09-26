package com.example.dynamicfeature.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FeatureRepository @Inject constructor() {
    var token: String? = null
}