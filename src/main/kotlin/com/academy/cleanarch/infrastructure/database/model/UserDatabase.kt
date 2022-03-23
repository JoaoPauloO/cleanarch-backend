package com.academy.cleanarch.infrastructure.database.model

import org.hibernate.validator.constraints.br.CPF
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Entity
class UserDatabase(
    @field:NotBlank
    @Column(nullable = false)
    val name: String,

    @field:NotBlank
    @field:Email
    @Column(nullable = false, unique = true)
    val email: String,

    @field:CPF
    @Column(nullable = false, unique = true)
    val cpf: String,

    @Column(nullable = false)
    val birthDate: LocalDate
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}