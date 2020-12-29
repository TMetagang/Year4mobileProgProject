package com.example.year4mobileprogproject.domain.usecase

import com.example.year4mobileprogproject.data.repository.UserRepository
import com.example.year4mobileprogproject.domain.entity.User

class CreateUserUseCase(private val userRepository: UserRepository) {

    suspend fun invoke (user: User){
        userRepository.createUser(user)

    }
}