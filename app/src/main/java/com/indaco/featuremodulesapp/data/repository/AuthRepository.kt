package com.indaco.featuremodulesapp.data.repository

import com.indaco.data.models.auth.User
import com.indaco.featuremodulesapp.data.storage.cache.AuthCache
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(private val authCache: AuthCache) {

    suspend fun getUsers(): Flow<List<User>?> = flowOf(authCache.getUsers())

    fun addUser(user: User) = authCache.addUser(user)
}