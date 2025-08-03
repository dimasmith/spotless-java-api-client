// File generated from our OpenAPI spec by Stainless.

package com.spotless.api.client

import com.spotless.api.core.ClientOptions
import com.spotless.api.core.RequestOptions
import com.spotless.api.core.http.HttpResponse
import com.spotless.api.models.ClientListVersionsParams
import com.spotless.api.models.ClientRetrieveVersionDetailsParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * A client for interacting with the Spotless REST API asynchronously. You can also switch to
 * synchronous execution via the [sync] method.
 *
 * This client performs best when you create a single instance and reuse it for all interactions
 * with the REST API. This is because each client holds its own connection pool and thread pools.
 * Reusing connections and threads reduces latency and saves memory. The client also handles rate
 * limiting per client. This means that creating and using multiple instances at the same time will
 * not respect rate limits.
 *
 * The threads and connections that are held will be released automatically if they remain idle. But
 * if you are writing an application that needs to aggressively release unused resources, then you
 * may call [close].
 */
interface SpotlessClientAsync {

    /**
     * Returns a version of this client that uses synchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun sync(): SpotlessClient

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpotlessClientAsync

    /** List API versions */
    fun listVersions(): CompletableFuture<Void?> = listVersions(ClientListVersionsParams.none())

    /** @see listVersions */
    fun listVersions(
        params: ClientListVersionsParams = ClientListVersionsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see listVersions */
    fun listVersions(
        params: ClientListVersionsParams = ClientListVersionsParams.none()
    ): CompletableFuture<Void?> = listVersions(params, RequestOptions.none())

    /** @see listVersions */
    fun listVersions(requestOptions: RequestOptions): CompletableFuture<Void?> =
        listVersions(ClientListVersionsParams.none(), requestOptions)

    /** Show API version details */
    fun retrieveVersionDetails(): CompletableFuture<Void?> =
        retrieveVersionDetails(ClientRetrieveVersionDetailsParams.none())

    /** @see retrieveVersionDetails */
    fun retrieveVersionDetails(
        params: ClientRetrieveVersionDetailsParams = ClientRetrieveVersionDetailsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see retrieveVersionDetails */
    fun retrieveVersionDetails(
        params: ClientRetrieveVersionDetailsParams = ClientRetrieveVersionDetailsParams.none()
    ): CompletableFuture<Void?> = retrieveVersionDetails(params, RequestOptions.none())

    /** @see retrieveVersionDetails */
    fun retrieveVersionDetails(requestOptions: RequestOptions): CompletableFuture<Void?> =
        retrieveVersionDetails(ClientRetrieveVersionDetailsParams.none(), requestOptions)

    /**
     * Closes this client, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because the client is long-lived and
     * usually should not be synchronously closed via try-with-resources.
     *
     * It's also usually not necessary to call this method at all. the default HTTP client
     * automatically releases threads and connections if they remain idle, but if you are writing an
     * application that needs to aggressively release unused resources, then you may call this
     * method.
     */
    fun close()

    /**
     * A view of [SpotlessClientAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SpotlessClientAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /`, but is otherwise the same as
         * [SpotlessClientAsync.listVersions].
         */
        fun listVersions(): CompletableFuture<HttpResponse> =
            listVersions(ClientListVersionsParams.none())

        /** @see listVersions */
        fun listVersions(
            params: ClientListVersionsParams = ClientListVersionsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see listVersions */
        fun listVersions(
            params: ClientListVersionsParams = ClientListVersionsParams.none()
        ): CompletableFuture<HttpResponse> = listVersions(params, RequestOptions.none())

        /** @see listVersions */
        fun listVersions(requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
            listVersions(ClientListVersionsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v2`, but is otherwise the same as
         * [SpotlessClientAsync.retrieveVersionDetails].
         */
        fun retrieveVersionDetails(): CompletableFuture<HttpResponse> =
            retrieveVersionDetails(ClientRetrieveVersionDetailsParams.none())

        /** @see retrieveVersionDetails */
        fun retrieveVersionDetails(
            params: ClientRetrieveVersionDetailsParams = ClientRetrieveVersionDetailsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see retrieveVersionDetails */
        fun retrieveVersionDetails(
            params: ClientRetrieveVersionDetailsParams = ClientRetrieveVersionDetailsParams.none()
        ): CompletableFuture<HttpResponse> = retrieveVersionDetails(params, RequestOptions.none())

        /** @see retrieveVersionDetails */
        fun retrieveVersionDetails(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponse> =
            retrieveVersionDetails(ClientRetrieveVersionDetailsParams.none(), requestOptions)
    }
}
