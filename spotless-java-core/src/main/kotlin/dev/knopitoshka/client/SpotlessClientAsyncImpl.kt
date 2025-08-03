// File generated from our OpenAPI spec by Stainless.

package dev.knopitoshka.client

import dev.knopitoshka.core.ClientOptions
import dev.knopitoshka.core.getPackageVersion
import dev.knopitoshka.services.async.GameServiceAsync
import dev.knopitoshka.services.async.GameServiceAsyncImpl
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

    private val games: GameServiceAsync by lazy { GameServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): SpotlessClient = sync

    override fun withRawResponse(): SpotlessClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpotlessClientAsync =
        SpotlessClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun games(): GameServiceAsync = games

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SpotlessClientAsync.WithRawResponse {

        private val games: GameServiceAsync.WithRawResponse by lazy {
            GameServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SpotlessClientAsync.WithRawResponse =
            SpotlessClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun games(): GameServiceAsync.WithRawResponse = games
    }
}
