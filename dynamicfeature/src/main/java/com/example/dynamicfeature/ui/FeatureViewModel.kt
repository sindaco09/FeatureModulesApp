package com.example.dynamicfeature.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dynamicfeature.data.FeatureRepository
import com.example.featuremodulesapp.core.hilt.IODispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

//@HiltViewModel
class FeatureViewModel @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val repo: FeatureRepository
): ViewModel() {

    private val _token = MutableLiveData<String?>()
    val token: LiveData<String?> get() = _token

    fun setToken(token: String?) {
        repo.token = token
        _token.postValue(token)
    }

    fun getToken(): String? = repo.token
}