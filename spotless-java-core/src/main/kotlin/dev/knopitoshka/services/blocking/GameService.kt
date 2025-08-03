// File generated from our OpenAPI spec by Stainless.

package dev.knopitoshka.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import dev.knopitoshka.core.ClientOptions
import dev.knopitoshka.core.RequestOptions
import dev.knopitoshka.core.http.HttpResponseFor
import dev.knopitoshka.models.games.GameStartParams
import dev.knopitoshka.models.games.GameStartResponse
import java.util.function.Consumer

interface GameService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): GameService

    /** Starts a new game of chess. */
    fun start(): GameStartResponse = start(GameStartParams.none())

    /** @see start */
    fun start(
        params: GameStartParams = GameStartParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GameStartResponse

    /** @see start */
    fun start(params: GameStartParams = GameStartParams.none()): GameStartResponse =
        start(params, RequestOptions.none())

    /** @see start */
    fun start(requestOptions: RequestOptions): GameStartResponse =
        start(GameStartParams.none(), requestOptions)

    /** A view of [GameService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): GameService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /games`, but is otherwise the same as
         * [GameService.start].
         */
        @MustBeClosed
        fun start(): HttpResponseFor<GameStartResponse> = start(GameStartParams.none())

        /** @see start */
        @MustBeClosed
        fun start(
            params: GameStartParams = GameStartParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GameStartResponse>

        /** @see start */
        @MustBeClosed
        fun start(
            params: GameStartParams = GameStartParams.none()
        ): HttpResponseFor<GameStartResponse> = start(params, RequestOptions.none())

        /** @see start */
        @MustBeClosed
        fun start(requestOptions: RequestOptions): HttpResponseFor<GameStartResponse> =
            start(GameStartParams.none(), requestOptions)
    }
}
