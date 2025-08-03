package com.spotless.api.errors

class SpotlessIoException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : SpotlessException(message, cause)
