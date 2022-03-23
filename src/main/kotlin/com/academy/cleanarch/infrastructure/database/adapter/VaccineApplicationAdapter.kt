package com.academy.cleanarch.infrastructure.database.adapter

import com.academy.cleanarch.infrastructure.database.model.UserDatabase
import com.academy.cleanarch.infrastructure.database.model.VaccineApplicationDatabase

class VaccineApplicationAdapter {
    companion object {
        fun create(name: String, userDatabase: UserDatabase) = VaccineApplicationDatabase (
            name,
            userDatabase
        )
    }
}