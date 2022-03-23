package com.academy.cleanarch.infrastructure.database.repository

import com.academy.cleanarch.infrastructure.database.model.UserDatabase
import org.springframework.data.jpa.repository.JpaRepository

interface UserDatabaseRepository : JpaRepository<UserDatabase, Long> {
    fun findByEmail(email: String): UserDatabase
}