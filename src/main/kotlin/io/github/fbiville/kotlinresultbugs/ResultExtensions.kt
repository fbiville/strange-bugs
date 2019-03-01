package io.github.fbiville.kotlinresultbugs

fun <T, U> Result<T>.flatMap(function: (T) -> Result<U>): Result<U> {
    return if (isSuccess) {
        function(getOrNull()!!)
    } else {
        Result.failure(this.exceptionOrNull()!!)
    }
}

fun <T> Result<T>.forEach(consumer: (T) -> Unit) {
    if (this.isSuccess) {
        consumer(getOrNull()!!)
    }
}