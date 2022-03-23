package com.academy.cleanarch.infrastructure.database.repository

import com.academy.cleanarch.infrastructure.database.model.VaccineApplicationDatabase
import org.springframework.data.jpa.repository.JpaRepository

interface VaccineApplicationDatabaseRepository : JpaRepository<VaccineApplicationDatabase, Long>