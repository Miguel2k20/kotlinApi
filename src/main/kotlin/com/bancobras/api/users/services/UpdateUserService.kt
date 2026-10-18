package com.bancobras.api.users.services

import com.bancobras.api.users.dto.UpdateUserRequest
import com.bancobras.api.users.repositories.UserRepository
import com.bancobras.api.users.models.User
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UpdateUserService (
    private val userRepository: UserRepository
) {
    fun execute( id: Long, request: UpdateUserRequest ) : User
    {
        val user = userRepository.findById(id).orElseThrow {
            ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Usuário não encontrado"
            )
        }
        
        user.apply { 
            request.name?.let { name = it }
            request.email?.let { email = it }
        }
        
        return userRepository.save(user)
    }
}