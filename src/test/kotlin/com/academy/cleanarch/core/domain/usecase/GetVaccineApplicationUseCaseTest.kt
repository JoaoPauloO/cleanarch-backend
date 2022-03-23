package com.academy.cleanarch.core.domain.usecase

import com.academy.cleanarch.core.domain.model.VaccineApplication
import com.academy.cleanarch.core.domain.repository.VaccineApplicationRepository
import com.academy.cleanarch.core.domain.usecase.GetVaccineApplicationUseCase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class GetVaccineApplicationUseCaseTest {

    private val useCaseMock: GetVaccineApplicationUseCase = mock(GetVaccineApplicationUseCase::class.java)
    private val repositoryMock = mock(VaccineApplicationRepository::class.java)

    private val applicationId = 1L

    private val vaccineApplication = VaccineApplication(
        "COVID",
        "Joca@gmail.com"
    ).apply {
        id = applicationId
    }

    @Test
    fun `must return a vaccine application`() {
        `when`(useCaseMock(applicationId)).thenReturn(vaccineApplication)
        val applicationResponse = useCaseMock(applicationId)
        assertEquals(vaccineApplication, applicationResponse)
    }

    @Test
    fun `must called useCase()`() {
        useCaseMock(applicationId)
        verify(useCaseMock).invoke(applicationId)
    }

    @Test
    fun `must called repository`() {
        val useCaseNotMocked = GetVaccineApplicationUseCase(repositoryMock)
        useCaseNotMocked(applicationId)
        verify(repositoryMock).getVaccineApplication(applicationId)
    }
}