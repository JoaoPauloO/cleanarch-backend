package com.academy.cleanarch.data.repository

import com.academy.cleanarch.core.domain.model.User
import com.academy.cleanarch.core.domain.repository.UserRepository
import com.academy.cleanarch.infrastructure.database.adapter.UserAdapter
import com.academy.cleanarch.infrastructure.database.repository.UserDatabaseRepository
import org.springframework.stereotype.Service

@Service
class UserRepositoryImpl(
    private val repository: UserDatabaseRepository
) : UserRepository {
    override fun insertUser(user: User): Long {
        val userDatabase = UserAdapter.create(user.name, user.email, user.cpf, user.birthDate)
        repository.save(userDatabase)

        return userDatabase.id.let {
            return@let it
        } ?: throw Exception("Unmanaged entity.")
    }
}