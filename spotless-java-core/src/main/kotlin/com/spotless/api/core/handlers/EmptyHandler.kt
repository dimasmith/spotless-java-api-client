@file:JvmName("EmptyHandler")

package com.spotless.api.core.handlers

import com.spotless.api.core.http.HttpResponse
import com.spotless.api.core.http.HttpResponse.Handler

@JvmSynthetic internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
