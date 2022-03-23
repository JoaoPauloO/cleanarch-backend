package com.academy.cleanarch.core.domain.repository

import com.academy.cleanarch.core.domain.model.User

interface UserRepository {
    fun insertUser(user: User): Long
}