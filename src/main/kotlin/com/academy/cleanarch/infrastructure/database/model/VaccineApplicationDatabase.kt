package com.academy.cleanarch.infrastructure.database.model

import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
class VaccineApplicationDatabase(
    @field:NotNull
    @Column(nullable = false)
    val name: String,

    @field:NotNull
    @field:ManyToOne
    val user: UserDatabase
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    val applicationDate: LocalDateTime = LocalDateTime.now()
}