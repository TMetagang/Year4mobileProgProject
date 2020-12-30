package com.example.year4mobileprogproject.data.repository

import com.example.year4mobileprogproject.data.local.DatabaseDao
import com.example.year4mobileprogproject.data.local.models.toData
import com.example.year4mobileprogproject.data.local.models.toEntity
import com.example.year4mobileprogproject.domain.entity.User

class UserRepository(
    private val databaseDao: DatabaseDao) {

    suspend fun createUser(user: User){
        databaseDao.insert(user.toData())
    }

    fun getUser(email: String): User {
        val userlocal = databaseDao.findByName(email)
        return userlocal.toEntity()
    }

}