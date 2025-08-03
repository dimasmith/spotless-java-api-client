// File generated from our OpenAPI spec by Stainless.

package dev.knopitoshka.services.async

import dev.knopitoshka.core.ClientOptions
import dev.knopitoshka.core.RequestOptions
import dev.knopitoshka.core.http.HttpResponseFor
import dev.knopitoshka.models.games.GameStartParams
import dev.knopitoshka.models.games.GameStartResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface GameServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): GameServiceAsync

    /** Starts a new game of chess. */
    fun start(): CompletableFuture<GameStartResponse> = start(GameStartParams.none())

    /** @see start */
    fun start(
        params: GameStartParams = GameStartParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GameStartResponse>

    /** @see start */
    fun start(
        params: GameStartParams = GameStartParams.none()
    ): CompletableFuture<GameStartResponse> = start(params, RequestOptions.none())

    /** @see start */
    fun start(requestOptions: RequestOptions): CompletableFuture<GameStartResponse> =
        start(GameStartParams.none(), requestOptions)

    /** A view of [GameServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): GameServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /games`, but is otherwise the same as
         * [GameServiceAsync.start].
         */
        fun start(): CompletableFuture<HttpResponseFor<GameStartResponse>> =
            start(GameStartParams.none())

        /** @see start */
        fun start(
            params: GameStartParams = GameStartParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GameStartResponse>>

        /** @see start */
        fun start(
            params: GameStartParams = GameStartParams.none()
        ): CompletableFuture<HttpResponseFor<GameStartResponse>> =
            start(params, RequestOptions.none())

        /** @see start */
        fun start(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<GameStartResponse>> =
            start(GameStartParams.none(), requestOptions)
    }
}
