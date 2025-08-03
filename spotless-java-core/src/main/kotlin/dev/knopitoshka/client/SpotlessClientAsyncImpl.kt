// File generated from our OpenAPI spec by Stainless.

package dev.knopitoshka.client

import dev.knopitoshka.core.ClientOptions
import dev.knopitoshka.core.RequestOptions
import dev.knopitoshka.core.getPackageVersion
import dev.knopitoshka.core.handlers.emptyHandler
import dev.knopitoshka.core.handlers.errorBodyHandler
import dev.knopitoshka.core.handlers.errorHandler
import dev.knopitoshka.core.http.HttpMethod
import dev.knopitoshka.core.http.HttpRequest
import dev.knopitoshka.core.http.HttpResponse
import dev.knopitoshka.core.http.HttpResponse.Handler
import dev.knopitoshka.core.http.parseable
import dev.knopitoshka.core.prepareAsync
import dev.knopitoshka.models.ClientListVersionsParams
import dev.knopitoshka.models.ClientRetrieveVersionDetailsParams
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
