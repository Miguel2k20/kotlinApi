package com.bancobras.api.users.services

import com.bancobras.api.users.dto.CreateUserRequest
import com.bancobras.api.users.repositories.UserRepository
import com.bancobras.api.users.models.User
import org.springframework.stereotype.Service

@Service
class CreateUserService (
    private val userRepository: UserRepository
) {
    fun execute(request: CreateUserRequest): User 
    {
        
        if(userRepository.existsByEmail(request.email))
        {
            throw Exception("Email já cadastrado")
        }
        
        val user = User(
            name = request.name,
            email = request.email
        )
        
        return userRepository.save(user)
        
    }
}