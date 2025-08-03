// File generated from our OpenAPI spec by Stainless.

package com.spotless.api.client

import com.spotless.api.core.ClientOptions
import com.spotless.api.core.RequestOptions
import com.spotless.api.core.getPackageVersion
import com.spotless.api.core.handlers.emptyHandler
import com.spotless.api.core.handlers.errorBodyHandler
import com.spotless.api.core.handlers.errorHandler
import com.spotless.api.core.http.HttpMethod
import com.spotless.api.core.http.HttpRequest
import com.spotless.api.core.http.HttpResponse
import com.spotless.api.core.http.HttpResponse.Handler
import com.spotless.api.core.http.parseable
import com.spotless.api.core.prepare
import com.spotless.api.models.ClientListVersionsParams
import com.spotless.api.models.ClientRetrieveVersionDetailsParams
import java.util.function.Consumer

class SpotlessClientImpl(private val clientOptions: ClientOptions) : SpotlessClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: SpotlessClientAsync by lazy { SpotlessClientAsyncImpl(clientOptions) }

    private val withRawResponse: SpotlessClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun async(): SpotlessClientAsync = async

    override fun withRawResponse(): SpotlessClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpotlessClient =
        SpotlessClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun listVersions(params: ClientListVersionsParams, requestOptions: RequestOptions) {
        // get /
        withRawResponse().listVersions(params, requestOptions)
    }

    override fun retrieveVersionDetails(
        params: ClientRetrieveVersionDetailsParams,
        requestOptions: RequestOptions,
    ) {
        // get /v2
        withRawResponse().retrieveVersionDetails(params, requestOptions)
    }

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SpotlessClient.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SpotlessClient.WithRawResponse =
            SpotlessClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listVersionsHandler: Handler<Void?> = emptyHandler()

        override fun listVersions(
            params: ClientListVersionsParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { listVersionsHandler.handle(it) }
            }
        }

        private val retrieveVersionDetailsHandler: Handler<Void?> = emptyHandler()

        override fun retrieveVersionDetails(
            params: ClientRetrieveVersionDetailsParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { retrieveVersionDetailsHandler.handle(it) }
            }
        }
    }
}
