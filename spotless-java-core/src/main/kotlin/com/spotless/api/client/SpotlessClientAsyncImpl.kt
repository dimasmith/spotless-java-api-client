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
import com.spotless.api.core.prepareAsync
import com.spotless.api.models.ClientListVersionsParams
import com.spotless.api.models.ClientRetrieveVersionDetailsParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class SpotlessClientAsyncImpl(private val clientOptions: ClientOptions) : SpotlessClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: SpotlessClient by lazy { SpotlessClientImpl(clientOptions) }

    private val withRawResponse: SpotlessClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun sync(): SpotlessClient = sync

    override fun withRawResponse(): SpotlessClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpotlessClientAsync =
        SpotlessClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun listVersions(
        params: ClientListVersionsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // get /
        withRawResponse().listVersions(params, requestOptions).thenAccept {}

    override fun retrieveVersionDetails(
        params: ClientRetrieveVersionDetailsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // get /v2
        withRawResponse().retrieveVersionDetails(params, requestOptions).thenAccept {}

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SpotlessClientAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SpotlessClientAsync.WithRawResponse =
            SpotlessClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listVersionsHandler: Handler<Void?> = emptyHandler()

        override fun listVersions(
            params: ClientListVersionsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response.use { listVersionsHandler.handle(it) }
                    }
                }
        }

        private val retrieveVersionDetailsHandler: Handler<Void?> = emptyHandler()

        override fun retrieveVersionDetails(
            params: ClientRetrieveVersionDetailsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response.use { retrieveVersionDetailsHandler.handle(it) }
                    }
                }
        }
    }
}
