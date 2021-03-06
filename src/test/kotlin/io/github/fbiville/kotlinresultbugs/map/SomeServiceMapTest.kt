package io.github.fbiville.kotlinresultbugs.map

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.github.fbiville.kotlinresultbugs.SomeClient
import io.github.fbiville.kotlinresultbugs.SomeService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SomeServiceMapTest {
    private val client = mock<SomeClient>()
    private lateinit var service: SomeService

    @BeforeEach
    fun `set up`() {
        val strings = Result.success(listOf("a", "b"))
        whenever(client.getItems()).thenReturn(strings)
        service = SomeService(client)
    }

    @Test
    fun `ClassCastException bug - computes lengths`() {
        val lengths = service.lengths()

        assertEquals(listOf(1, 1), lengths.getOrNull())
    }

    @Test
    fun `no bug - computes lengths`() {
        assertEquals(listOf(5, 5, 1), SomeService(SomeClient()).lengths().getOrNull())
    }
}