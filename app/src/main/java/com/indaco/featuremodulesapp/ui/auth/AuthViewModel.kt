package com.indaco.featuremodulesapp.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indaco.featuremodulesapp.core.hilt.IODispatcher
import com.indaco.featuremodulesapp.data.models.auth.User
import com.indaco.featuremodulesapp.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val authRepository: AuthRepository
): ViewModel() {

    private val _loggedIn = MutableLiveData<Boolean>()
    val loggedIn: LiveData<Boolean> get() = _loggedIn

    private val _users = MutableLiveData<List<User>?>()
    val users: LiveData<List<User>?> get() = _users

    fun getUsers() {
        viewModelScope.launch(dispatcher) {
            authRepository.getUsers().collect {
                _users.postValue(it)
            }
        }
    }

    fun addUser(username: String) {
        viewModelScope.launch(dispatcher) {
            authRepository.addUser(User(username))
            getUsers()
        }
    }

    fun login(username: String) {
        viewModelScope.launch(dispatcher) {
            authRepository.getUsers().collect {
                _loggedIn.postValue(it?.contains(User(username)) == true)
            }
        }
    }
}