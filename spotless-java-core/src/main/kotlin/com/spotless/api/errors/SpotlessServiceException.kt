// File generated from our OpenAPI spec by Stainless.

package com.spotless.api.errors

import com.spotless.api.core.JsonValue
import com.spotless.api.core.http.Headers

abstract class SpotlessServiceException
protected constructor(message: String, cause: Throwable? = null) :
    SpotlessException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
