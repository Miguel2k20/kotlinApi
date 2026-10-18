package com.bancobras.api.users.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UpdateUserRequest (
    
    @field:NotBlank(message = "Nome não pode ser vazio")
    @field:Size(min = 3, max = 255, message = "Nome deve ter entre 3 e 255 caracteres")
    val name: String? = null,
    
    @field:NotBlank(message = "Email não pode ser vazio")
    @field:Email(message = "Email inválido")
    val email: String? = null
    
)