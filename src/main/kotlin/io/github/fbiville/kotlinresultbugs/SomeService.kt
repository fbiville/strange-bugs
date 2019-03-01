package io.github.fbiville.kotlinresultbugs

class SomeService(private val someClient: SomeClient) {

    fun sumLengths(): Result<Int> {
        return someClient.getItems().flatMap {
            addLengths(it)
        }
    }


    private fun addLengths(items: List<String>): Result<Int> {
        return Result.success(
                items.map { it.length }.reduce { a, b -> a + b })
    }
}

open class SomeClient {

    open fun getItems(): Result<List<String>> {
        return Result.success(listOf("hello", "world", "!"))
    }
}