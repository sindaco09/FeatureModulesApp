package com.example.dynamicfeature.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dynamicfeature.data.FeatureRepository
import com.example.featuremodulesapp.core.hilt.IODispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class FeatureViewModel @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val repo: FeatureRepository
): ViewModel() {

    private val _token = MutableLiveData<String?>()
    val token: LiveData<String?> get() = _token

    fun setToken(token: String?) {
        viewModelScope.launch(dispatcher) {
            delay(1000)  // Network Call
            repo.token = token.also { _token.postValue(it) }
        }
    }

    private fun getToken(): String? = repo.token

    fun printPrettyToken() = "Token: ${getToken()}"
}