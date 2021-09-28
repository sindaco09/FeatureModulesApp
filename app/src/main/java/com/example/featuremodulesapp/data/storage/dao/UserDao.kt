package com.example.featuremodulesapp.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.featuremodulesapp.data.models.auth.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    suspend fun getUsers(): List<User>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUsers(list: List<User>?)
}