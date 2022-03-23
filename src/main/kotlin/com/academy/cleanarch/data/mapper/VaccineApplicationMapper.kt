package com.academy.cleanarch.data.mapper

import com.academy.cleanarch.core.domain.model.VaccineApplication
import com.academy.cleanarch.infrastructure.database.model.VaccineApplicationDatabase

class VaccineApplicationMapper {
    companion object {
        fun toDomain(vaccineApplicationDatabase: VaccineApplicationDatabase) = VaccineApplication(
            vaccineApplicationDatabase.name,
            vaccineApplicationDatabase.user.email
        ).apply {
            this.id = vaccineApplicationDatabase.id
            this.applicationDate = vaccineApplicationDatabase.applicationDate
        }
    }
}