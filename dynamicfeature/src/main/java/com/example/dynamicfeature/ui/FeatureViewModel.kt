package com.example.dynamicfeature.ui

import androidx.lifecycle.*
import com.example.dynamicfeature.data.FeatureRepository
import com.example.featuremodulesapp.core.hilt.IODispatcher
import com.example.featuremodulesapp.data.repository.MainRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class FeatureViewModel @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val featureRepository: FeatureRepository,
    private val mainRepository: MainRepository
): ViewModel() {

    private val _token = MutableLiveData<String?>()
    val token: LiveData<String?> get() = _token

    fun setToken(token: String?) {
        viewModelScope.launch(dispatcher) {
            delay(1000)  // Network Call
            featureRepository.token = token.also { _token.postValue(it) }
        }
    }

    fun getToken(): String? = featureRepository.token

    fun getRepos() = liveData(dispatcher) { emit(featureRepository.getRepos())}


    // -------------- MainRepository ------------------

    private val _username = MutableLiveData<String?>()
    val username: LiveData<String?> get() = _username

    fun getUserName(): String? = mainRepository.username

    fun setUserName(username: String?) {
        viewModelScope.launch(dispatcher) {
            delay(1000)
            mainRepository.username = username.also { _username.postValue(it) }
        }
    }
}