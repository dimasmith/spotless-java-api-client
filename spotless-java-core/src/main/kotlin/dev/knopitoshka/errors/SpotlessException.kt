package dev.knopitoshka.errors

open class SpotlessException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
