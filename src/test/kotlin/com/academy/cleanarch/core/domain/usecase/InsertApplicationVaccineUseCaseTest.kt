package com.academy.cleanarch.core.domain.usecase

import com.academy.cleanarch.core.domain.repository.VaccineApplicationRepository
import com.academy.cleanarch.data.mapper.VaccineApplicationRequestMapper
import com.academy.cleanarch.data.model.VaccineApplicationDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class InsertApplicationVaccineUseCaseTest {

    private val useCaseMock = mock(InsertApplicationVaccineUseCase::class.java)
    private val repositoryMock = mock(VaccineApplicationRepository::class.java)

    private val request = VaccineApplicationDto(
        "COVID",
        "Joca@gmail.com"
    )

    private val applicationId = 1L

    @Test
    fun `must return vaccine application id`() {
        `when`(useCaseMock(request)).thenReturn(applicationId)
        val applicationIdResponse = useCaseMock(request)
        assertEquals(applicationId, applicationIdResponse)
    }

    @Test
    fun `must called useCase()`() {
        useCaseMock(request)
        verify(useCaseMock).invoke(request)
    }

    @Test
    fun `must called repository`() {
        val useCaseNotMocked = InsertApplicationVaccineUseCase(repositoryMock)
        val vaccineApplication = VaccineApplicationRequestMapper.toDomain(request)

        useCaseNotMocked(request)
        verify(repositoryMock).insertVaccineApplication(vaccineApplication)
    }
}