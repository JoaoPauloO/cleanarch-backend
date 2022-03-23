package com.academy.cleanarch.core.domain.usecase

import com.academy.cleanarch.core.domain.repository.VaccineApplicationRepository
import com.academy.cleanarch.data.mapper.VaccineApplicationRequestMapper
import com.academy.cleanarch.data.model.VaccineApplicationDto
import org.springframework.stereotype.Service

@Service
class InsertApplicationVaccineUseCase(
    private val repository: VaccineApplicationRepository
) {
    operator fun invoke(request: VaccineApplicationDto): Long {
        val vaccineApplication = VaccineApplicationRequestMapper.toDomain(request)
        return repository.insertVaccineApplication(vaccineApplication)
    }
}