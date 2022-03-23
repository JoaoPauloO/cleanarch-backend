package com.academy.cleanarch.core.domain.usecase

import com.academy.cleanarch.core.domain.model.VaccineApplication
import com.academy.cleanarch.core.domain.repository.VaccineApplicationRepository
import org.springframework.stereotype.Service

@Service
class GetVaccineApplicationUseCase(
    private val repository: VaccineApplicationRepository
) {
    operator fun invoke(applicationId: Long): VaccineApplication {
       return repository.getVaccineApplication(applicationId)
    }
}