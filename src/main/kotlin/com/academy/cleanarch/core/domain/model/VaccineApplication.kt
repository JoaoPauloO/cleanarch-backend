package com.academy.cleanarch.core.domain.model

import java.time.LocalDateTime

class VaccineApplication(
    val name: String,
    val userEmail: String
) {
    var id: Long? = null
    var applicationDate: LocalDateTime? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as VaccineApplication

        if (name != other.name) return false
        if (userEmail != other.userEmail) return false
        if (id != other.id) return false
        if (applicationDate != other.applicationDate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + userEmail.hashCode()
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (applicationDate?.hashCode() ?: 0)
        return result
    }
}