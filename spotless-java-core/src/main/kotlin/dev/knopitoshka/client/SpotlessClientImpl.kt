// File generated from our OpenAPI spec by Stainless.

package dev.knopitoshka.client

import dev.knopitoshka.core.ClientOptions
import dev.knopitoshka.core.getPackageVersion
import dev.knopitoshka.services.blocking.GameService
import dev.knopitoshka.services.blocking.GameServiceImpl
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

    private val games: GameService by lazy { GameServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): SpotlessClientAsync = async

    override fun withRawResponse(): SpotlessClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpotlessClient =
        SpotlessClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun games(): GameService = games

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SpotlessClient.WithRawResponse {

        private val games: GameService.WithRawResponse by lazy {
            GameServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SpotlessClient.WithRawResponse =
            SpotlessClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun games(): GameService.WithRawResponse = games
    }
}
