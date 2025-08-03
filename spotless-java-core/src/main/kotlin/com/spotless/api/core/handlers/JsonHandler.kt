@file:JvmName("JsonHandler")

package com.spotless.api.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.spotless.api.core.http.HttpResponse
import com.spotless.api.core.http.HttpResponse.Handler
import com.spotless.api.errors.SpotlessInvalidDataException

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw SpotlessInvalidDataException("Error reading response", e)
            }
    }
