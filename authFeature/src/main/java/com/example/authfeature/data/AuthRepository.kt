package com.example.authfeature.data

import com.example.featuremodulesapp.data.models.auth.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(private val authCache: AuthCache) {

    suspend fun getUsers(): Flow<List<User>?> = flowOf(authCache.getUsers())

    fun addUser(user: User) = authCache.addUser(user)
}