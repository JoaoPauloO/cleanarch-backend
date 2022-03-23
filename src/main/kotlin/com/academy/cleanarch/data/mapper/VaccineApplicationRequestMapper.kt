package com.academy.cleanarch.data.mapper

import com.academy.cleanarch.core.domain.model.VaccineApplication
import com.academy.cleanarch.data.model.VaccineApplicationDto

class VaccineApplicationRequestMapper {
    companion object {
        fun toDomain(request: VaccineApplicationDto) = VaccineApplication(
            request.name,
            request.userEmail
        )
    }
}