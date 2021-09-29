package com.indaco.featuremodulesapp.data.storage.cache

import com.indaco.featuremodulesapp.data.models.auth.User
import com.indaco.featuremodulesapp.data.storage.dao.UserDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthCache @Inject constructor(private val userDao: UserDao) {

    suspend fun getUsers(): List<User>? = userDao.getUsers()

    fun addUser(user: User) = userDao.saveUsers(listOf(user))
}