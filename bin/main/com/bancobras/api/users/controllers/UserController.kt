package com.bancobras.api.users.controllers

import com.bancobras.api.users.dto.CreateUserRequest
import com.bancobras.api.users.dto.CreateUserResponsDTO
import com.bancobras.api.users.dto.ListUsersResponse
import com.bancobras.api.users.dto.ShowUsersResponse
import com.bancobras.api.users.dto.UpdateUserRequest
import com.bancobras.api.users.dto.UpdateUserResponseDTO
import com.bancobras.api.users.models.User
import com.bancobras.api.users.services.CreateUserService
import com.bancobras.api.users.services.ListUsersService
import com.bancobras.api.users.services.ShowUserService
import com.bancobras.api.users.services.UpdateUserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val createUserService : CreateUserService,
    private val listUsersService : ListUsersService,
    private val showUserService : ShowUserService,
    private val updateUserService : UpdateUserService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @Valid @RequestBody request: CreateUserRequest
    ): CreateUserResponsDTO {

        val user = createUserService.execute(request)

        return CreateUserResponsDTO(
            "Usuário criado com sucesso!",
            user
        )
    }

    @GetMapping
    fun index(): List<ListUsersResponse> {
        return listUsersService.execute()
    }
    
    @GetMapping("/{id}")
    fun show(@PathVariable id: Long) : ShowUsersResponse {
        return showUserService.execute(id)
    }
    
    @PutMapping("/{id}")
    fun update (
        @PathVariable id: Long, 
        @Valid @RequestBody request: UpdateUserRequest
    ) : UpdateUserResponseDTO 
    {
        val user = updateUserService.execute(id, request)
        return UpdateUserResponseDTO(
            "Usuário atualizado com sucesso", 
            user
        )
    }
}
