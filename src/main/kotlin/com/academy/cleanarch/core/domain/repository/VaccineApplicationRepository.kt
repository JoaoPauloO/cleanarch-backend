package com.academy.cleanarch.core.domain.repository

import com.academy.cleanarch.core.domain.model.VaccineApplication

interface VaccineApplicationRepository {
    fun insertVaccineApplication(vaccineApplication: VaccineApplication): Long
    fun getVaccineApplication(applicationId: Long): VaccineApplication
}