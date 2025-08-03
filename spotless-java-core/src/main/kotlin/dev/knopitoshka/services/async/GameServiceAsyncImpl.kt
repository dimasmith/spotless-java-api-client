// File generated from our OpenAPI spec by Stainless.

package dev.knopitoshka.services.async

import dev.knopitoshka.core.ClientOptions
import dev.knopitoshka.core.RequestOptions
import dev.knopitoshka.core.handlers.errorBodyHandler
import dev.knopitoshka.core.handlers.errorHandler
import dev.knopitoshka.core.handlers.jsonHandler
import dev.knopitoshka.core.http.HttpMethod
import dev.knopitoshka.core.http.HttpRequest
import dev.knopitoshka.core.http.HttpResponse
import dev.knopitoshka.core.http.HttpResponse.Handler
import dev.knopitoshka.core.http.HttpResponseFor
import dev.knopitoshka.core.http.json
import dev.knopitoshka.core.http.parseable
import dev.knopitoshka.core.prepareAsync
import dev.knopitoshka.models.games.GameStartParams
import dev.knopitoshka.models.games.GameStartResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class GameServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    GameServiceAsync {

    private val withRawResponse: GameServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): GameServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): GameServiceAsync =
        GameServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun start(
        params: GameStartParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<GameStartResponse> =
        // post /games
        withRawResponse().start(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GameServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GameServiceAsync.WithRawResponse =
            GameServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val startHandler: Handler<GameStartResponse> =
            jsonHandler<GameStartResponse>(clientOptions.jsonMapper)

        override fun start(
            params: GameStartParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GameStartResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("games")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { startHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
