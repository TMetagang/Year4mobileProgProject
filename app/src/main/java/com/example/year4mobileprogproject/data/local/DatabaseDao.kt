package com.example.year4mobileprogproject.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.year4mobileprogproject.data.local.models.UserLocal
import com.example.year4mobileprogproject.domain.entity.User

@Dao
interface DatabaseDao {
    @Query("SELECT * FROM UserLocal")
    fun getAll(): List<User>

    @Query("SELECT * FROM UserLocal WHERE email LIKE :email LIMIT 1")
    fun findByName(email: String): UserLocal

    @Insert
    fun insert(users: UserLocal)

    @Delete
    fun delete(user:
               UserLocal)
}