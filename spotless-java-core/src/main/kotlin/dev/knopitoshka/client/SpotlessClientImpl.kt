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
import dev.knopitoshka.core.prepare
import dev.knopitoshka.models.ClientListVersionsParams
import dev.knopitoshka.models.ClientRetrieveVersionDetailsParams
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
