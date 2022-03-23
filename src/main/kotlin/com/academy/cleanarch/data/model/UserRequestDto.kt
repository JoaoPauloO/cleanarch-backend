package com.academy.cleanarch.data.model

import java.time.LocalDate

data class UserRequestDto(
    val name: String,
    val email: String,
    val cpf: String,
    val birthDate: LocalDate
)