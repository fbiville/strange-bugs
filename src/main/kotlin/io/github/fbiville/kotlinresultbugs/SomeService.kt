package io.github.fbiville.kotlinresultbugs

class SomeService(private val someClient: SomeClient) {

    fun sumLengths(): Result<Int> {
        return someClient.getItems().flatMap {
            addLengths(it)
        }
    }

    fun lengths(): Result<List<Int>> {
        return someClient.getItems().map(::getLengths)
    }


    private fun addLengths(items: List<String>): Result<Int> {
        return Result.success(getLengths(items).reduce { a, b -> a + b })
    }

    private fun getLengths(items: List<String>) = items.map { it.length }
}

open class SomeClient {

    open fun getItems(): Result<List<String>> {
        return Result.success(listOf("hello", "world", "!"))
    }
}