package com.bancobras.api.users.services

import com.bancobras.api.users.dto.ListUsersResponse
import com.bancobras.api.users.dto.ShowUsersResponse
import com.bancobras.api.users.repositories.UserRepository
import com.bancobras.api.users.models.User
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ShowUserService(
    private val userRepository: UserRepository
) {
    fun execute(id:Long): ShowUsersResponse
    {
        val user = userRepository.findById(id).orElseThrow {
            ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Usuário não encontrado"
            )
        }
        
        return ShowUsersResponse (
            id = requireNotNull(user.id),
            name = user.name,
            email = user.email,
            createBy = requireNotNull(user.createdAt)
        )
        
    }
}