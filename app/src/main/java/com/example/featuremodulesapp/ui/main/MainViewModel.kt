package com.example.featuremodulesapp.ui.main

import androidx.lifecycle.ViewModel
import com.example.featuremodulesapp.core.hilt.IODispatcher
import com.example.featuremodulesapp.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher
): ViewModel() {
}