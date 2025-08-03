// File generated from our OpenAPI spec by Stainless.

package dev.knopitoshka.services.blocking

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
import dev.knopitoshka.core.prepare
import dev.knopitoshka.models.games.GameStartParams
import dev.knopitoshka.models.games.GameStartResponse
import java.util.function.Consumer

class GameServiceImpl internal constructor(private val clientOptions: ClientOptions) : GameService {

    private val withRawResponse: GameService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): GameService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): GameService =
        GameServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun start(params: GameStartParams, requestOptions: RequestOptions): GameStartResponse =
        // post /games
        withRawResponse().start(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GameService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GameService.WithRawResponse =
            GameServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val startHandler: Handler<GameStartResponse> =
            jsonHandler<GameStartResponse>(clientOptions.jsonMapper)

        override fun start(
            params: GameStartParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GameStartResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("games")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
