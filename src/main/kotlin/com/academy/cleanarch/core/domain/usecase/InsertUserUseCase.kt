package com.academy.cleanarch.core.domain.usecase

import com.academy.cleanarch.core.domain.repository.UserRepository
import com.academy.cleanarch.data.mapper.UserRequestRequestMapper
import com.academy.cleanarch.data.model.UserRequestDto
import org.springframework.stereotype.Service

@Service
class InsertUserUseCase(
    private val repository: UserRepository
) {
    operator fun invoke(request: UserRequestDto): Long {
        val user = UserRequestRequestMapper.toDomain(request)
        return repository.insertUser(user)
    }
}