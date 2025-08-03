package com.spotless.api.errors

class SpotlessInvalidDataException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : SpotlessException(message, cause)
