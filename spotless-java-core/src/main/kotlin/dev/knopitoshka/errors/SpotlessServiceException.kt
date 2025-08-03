// File generated from our OpenAPI spec by Stainless.

package dev.knopitoshka.errors

import dev.knopitoshka.core.JsonValue
import dev.knopitoshka.core.http.Headers

abstract class SpotlessServiceException
protected constructor(message: String, cause: Throwable? = null) :
    SpotlessException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
