package com.academy.cleanarch.data.mapper

import com.academy.cleanarch.core.domain.model.User
import com.academy.cleanarch.data.model.UserRequestDto

class UserRequestRequestMapper {
    companion object {
        fun toDomain(request: UserRequestDto) = User(
            request.name,
            request.email,
            request.cpf,
            request.birthDate
        )
    }
}