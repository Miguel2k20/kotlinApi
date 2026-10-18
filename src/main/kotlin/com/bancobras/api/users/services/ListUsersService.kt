package com.bancobras.api.users.services

import com.bancobras.api.users.dto.ListUsersResponse
import com.bancobras.api.users.repositories.UserRepository
import com.bancobras.api.users.models.User
import org.springframework.stereotype.Service

@Service
class ListUsersService(
    private val userRepository: UserRepository
) {
    fun execute(): List<ListUsersResponse>
    {
        val allUsers: List<User> = userRepository.findAll()
        
        return allUsers.map { user: User ->
            ListUsersResponse(
                id = requireNotNull(user.id),
                name = user.name,
                email = user.email  
            )
        }
    }
}