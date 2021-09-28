package com.example.featuremodulesapp.data.models.auth

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(@PrimaryKey val username: String)