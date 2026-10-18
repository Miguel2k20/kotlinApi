package com.bancobras.api.users.repositories

import com.bancobras.api.users.models.User

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface UserRepository : JpaRepository<User, Long> {
    
    fun findByEmail(email: String): User?
    
    fun existsByEmail(email: String): Boolean
}