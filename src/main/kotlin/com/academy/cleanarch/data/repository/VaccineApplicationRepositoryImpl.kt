package com.academy.cleanarch.data.repository

import com.academy.cleanarch.core.domain.model.VaccineApplication
import com.academy.cleanarch.core.domain.repository.VaccineApplicationRepository
import com.academy.cleanarch.data.mapper.VaccineApplicationMapper
import com.academy.cleanarch.infrastructure.database.adapter.VaccineApplicationAdapter
import com.academy.cleanarch.infrastructure.database.repository.UserDatabaseRepository
import com.academy.cleanarch.infrastructure.database.repository.VaccineApplicationDatabaseRepository
import org.springframework.stereotype.Service

@Service
class VaccineApplicationRepositoryImpl(
    private val applicationRepository: VaccineApplicationDatabaseRepository,
    private val userRepository: UserDatabaseRepository
) : VaccineApplicationRepository {
    override fun insertVaccineApplication(vaccineApplication: VaccineApplication): Long {
        val userDatabase = userRepository.findByEmail(vaccineApplication.userEmail)
        val vaccineApplicationDatabase = VaccineApplicationAdapter.create(vaccineApplication.name, userDatabase)
        applicationRepository.save(vaccineApplicationDatabase)

        return vaccineApplicationDatabase.let {
            return@let it.id
        } ?: throw Exception("Unmanaged entity.")
    }

    override fun getVaccineApplication(applicationId: Long): VaccineApplication {
        val optional = applicationRepository.findById(applicationId)

        if(optional.isEmpty) {
            throw Exception("Vaccine application not registered")
        }

        val vaccineApplicationDatabase = optional.get()
        return VaccineApplicationMapper.toDomain(vaccineApplicationDatabase)
    }
}