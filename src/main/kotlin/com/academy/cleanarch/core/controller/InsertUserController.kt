package com.academy.cleanarch.core.controller

import com.academy.cleanarch.core.domain.usecase.InsertUserUseCase
import com.academy.cleanarch.data.model.UserRequestDto
import com.academy.cleanarch.util.URL_USER_LOCALHOST
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/insert/user")
class InsertUserController(
    private val insertUserUseCase: InsertUserUseCase
) {

    @PostMapping
    private fun insert(@RequestBody @Valid request: UserRequestDto): ResponseEntity<Any> {
        val userId = insertUserUseCase(request)
        val uri = URI.create("$URL_USER_LOCALHOST/${userId}")
        return ResponseEntity.created(uri).build()
    }
}