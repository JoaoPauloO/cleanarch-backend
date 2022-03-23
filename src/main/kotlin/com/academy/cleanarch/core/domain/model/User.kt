package com.academy.cleanarch.core.domain.model

import java.time.LocalDate

class User(
    val name: String,
    val email: String,
    val cpf: String,
    val birthDate: LocalDate
) {
    var id: Long? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (name != other.name) return false
        if (email != other.email) return false
        if (cpf != other.cpf) return false
        if (birthDate != other.birthDate) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + cpf.hashCode()
        result = 31 * result + birthDate.hashCode()
        result = 31 * result + (id?.hashCode() ?: 0)
        return result
    }
}