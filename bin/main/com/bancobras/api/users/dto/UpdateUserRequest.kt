package com.bancobras.api.users.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Size

data class UpdateUserRequest (
    
    @field:Size(min = 3, max = 255, message = "Nome deve ter entre 3 e 255 caracteres")
    val name: String? = null,
    
    @field:Email(message = "Email inválido")
    val email: String? = null
    
)