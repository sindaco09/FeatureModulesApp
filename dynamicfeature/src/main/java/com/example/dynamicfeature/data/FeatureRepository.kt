package com.example.dynamicfeature.data

import com.example.featuremodulesapp.core.hilt.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FeatureRepository @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher
) {
    var token: String? = null


}