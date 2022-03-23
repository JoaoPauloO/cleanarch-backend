package com.academy.cleanarch.infrastructure.database.adapter

import com.academy.cleanarch.infrastructure.database.model.UserDatabase
import java.time.LocalDate

class UserAdapter {
    companion object {
        fun create(name: String, email: String, cpf: String, birthDate: LocalDate) = UserDatabase(
            name, email, cpf, birthDate
        )
    }
}