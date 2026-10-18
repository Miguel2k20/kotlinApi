package com.bancobras.api.shared.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(
        ex: MethodArgumentNotValidException
    ): ResponseEntity<Map<String, Any>> {

        val errors = ex.bindingResult.fieldErrors
            .groupBy(
                { it.field },
                { it.defaultMessage ?: "Campo inválido" }
            )

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
            .body(
                mapOf(
                    "message" to "Os dados fornecidos são inválidos.",
                    "errors" to errors
                )
            )
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleInvalidBody(
        ex: HttpMessageNotReadableException
    ): ResponseEntity<Map<String, Any>> {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(
                mapOf(
                    "message" to "Corpo da requisição ausente ou inválido."
                )
            )
    }
}