package com.bancobras.api.users.dto
import java.time.LocalDateTime

data class ShowUsersResponse(
    val id: Long,
    val name: String,
    val email: String,
    val createBy: LocalDateTime
)
