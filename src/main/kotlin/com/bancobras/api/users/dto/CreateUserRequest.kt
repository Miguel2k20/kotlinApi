package com.bancobras.api.users.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateUserRequest (
    @field:NotBlank(message = "Nome é obrigatório")
    @field:Size(min = 3, max = 255, message = "Nome deve ter entre 3 e 255 caracteres")
    val name: String = "",
    @field:NotBlank(message = "Email é obrigatório")
    @field:Email(message = "Email inválido")
    val email: String = ""
)