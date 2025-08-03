@file:JvmName("JsonHandler")

package dev.knopitoshka.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dev.knopitoshka.core.http.HttpResponse
import dev.knopitoshka.core.http.HttpResponse.Handler
import dev.knopitoshka.errors.SpotlessInvalidDataException

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
