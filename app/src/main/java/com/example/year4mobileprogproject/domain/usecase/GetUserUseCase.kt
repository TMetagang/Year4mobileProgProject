package com.example.year4mobileprogproject.domain.usecase

import com.example.year4mobileprogproject.data.repository.UserRepository
import com.example.year4mobileprogproject.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {

    suspend fun invoke(email: String): User?{
        return userRepository.getUser(email)
    }
}