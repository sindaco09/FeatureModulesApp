package com.example.authfeature.data

import com.example.featuremodulesapp.data.models.auth.User
import com.example.featuremodulesapp.data.storage.dao.UserDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthCache @Inject constructor(private val userDao: UserDao) {

    suspend fun getUsers(): List<User>? = userDao.getUsers()

    fun addUser(user: User) = userDao.saveUsers(listOf(user))
}