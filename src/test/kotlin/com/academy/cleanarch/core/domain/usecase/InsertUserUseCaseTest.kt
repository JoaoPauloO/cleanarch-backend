package com.academy.cleanarch.core.domain.usecase

import com.academy.cleanarch.core.domain.repository.UserRepository
import com.academy.cleanarch.core.domain.usecase.InsertUserUseCase
import com.academy.cleanarch.data.mapper.UserRequestRequestMapper
import com.academy.cleanarch.data.model.UserRequestDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest
internal class InsertUserUseCaseTest {

    private val useCaseMock = mock(InsertUserUseCase::class.java)
    private val repositoryMock = mock(UserRepository::class.java)

    private val request = UserRequestDto(
        "Joao",
        "Joca@Gmail.com",
        "458.176.050-07",
        LocalDate.of(1996, 11, 7)
    )

    private val userId = 1L

    @Test
    fun `must return user id`() {
        `when`(useCaseMock(request)).thenReturn(userId)
        val userIdResponse = useCaseMock(request)
        assertEquals(userId, userIdResponse)
    }

    @Test
    fun `must called useCase()`() {
        useCaseMock(request)
        verify(useCaseMock).invoke(request)
    }

    @Test
    fun `must called repository`() {
        val useCaseNotMocked = InsertUserUseCase(repositoryMock)
        val user = UserRequestRequestMapper.toDomain(request)

        useCaseNotMocked(request)
        verify(repositoryMock).insertUser(user)
    }
}