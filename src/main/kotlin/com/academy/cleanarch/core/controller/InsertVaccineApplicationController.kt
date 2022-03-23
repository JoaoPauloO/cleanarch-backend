package com.academy.cleanarch.core.controller

import com.academy.cleanarch.core.domain.usecase.InsertApplicationVaccineUseCase
import com.academy.cleanarch.data.model.VaccineApplicationDto
import com.academy.cleanarch.util.URL_APPLICATION_LOCALHOST
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/insert/vaccine/application")
class InsertVaccineApplicationController(
    private val insertApplicationVaccineUseCase : InsertApplicationVaccineUseCase
) {

    @PostMapping
    private fun insert(@RequestBody @Valid request: VaccineApplicationDto): ResponseEntity<Any> {
        val vaccineApplicationId = insertApplicationVaccineUseCase(request)
        val uri = URI.create("$URL_APPLICATION_LOCALHOST/${vaccineApplicationId}")
        return ResponseEntity.created(uri).build()
    }
}