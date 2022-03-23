package com.academy.cleanarch.core.controller

import com.academy.cleanarch.core.domain.model.VaccineApplication
import com.academy.cleanarch.core.domain.usecase.GetVaccineApplicationUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/vaccine/application")
class GetVaccineApplicationController(
    private val useCase: GetVaccineApplicationUseCase
) {

    @GetMapping("/{applicationId}")
    fun getVaccineApplication(@PathVariable applicationId: Long): ResponseEntity<VaccineApplication> {
        val vaccineApplication = useCase(applicationId)
        return ResponseEntity.ok(vaccineApplication)
    }
}