package io.github.fbiville.kotlinresultbugs.foreach

import io.github.fbiville.kotlinresultbugs.forEach
import net.jqwik.api.*
import java.util.*

class ForEachGenerativeTest {


    @Property
    fun `does not iterate over failures`(@ForAll("failure") failure: Result<Any>): Boolean {
        var i = 0

        failure.forEach { i++ }

        return i == 0
    }

    @Provide
    fun failure(): Arbitrary<Result<Any>> {
        return Arbitraries.randomValue { random -> generateFailure(random) }
    }

    companion object {
        fun generateFailure(random: Random): Result<Any> = Result.failure(Throwable(random.nextInt().toString(10)))
    }
}