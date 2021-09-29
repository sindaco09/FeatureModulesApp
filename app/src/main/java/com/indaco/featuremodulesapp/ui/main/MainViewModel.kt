package com.indaco.featuremodulesapp.ui.main

import androidx.lifecycle.ViewModel
import com.indaco.featuremodulesapp.core.hilt.IODispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher
): ViewModel() {
}