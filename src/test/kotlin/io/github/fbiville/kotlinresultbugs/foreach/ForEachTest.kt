package io.github.fbiville.kotlinresultbugs.foreach

import io.github.fbiville.kotlinresultbugs.forEach
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals


class ForEachTest {

    @Test
    fun `does not iterate over failures`() {
        var i = 0

        Result.failure<Any>(Throwable("some")).forEach { i++ }

        assertEquals(0, i, "i should be incremented")
    }
}
