// File generated from our OpenAPI spec by Stainless.

package dev.knopitoshka.client

import com.google.errorprone.annotations.MustBeClosed
import dev.knopitoshka.core.ClientOptions
import dev.knopitoshka.core.RequestOptions
import dev.knopitoshka.core.http.HttpResponse
import dev.knopitoshka.models.ClientListVersionsParams
import dev.knopitoshka.models.ClientRetrieveVersionDetailsParams
import java.util.function.Consumer

/**
 * A client for interacting with the Spotless REST API synchronously. You can also switch to
 * asynchronous execution via the [async] method.
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
interface SpotlessClient {

    /**
     * Returns a version of this client that uses asynchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun async(): SpotlessClientAsync

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpotlessClient

    /** List API versions */
    fun listVersions() = listVersions(ClientListVersionsParams.none())

    /** @see listVersions */
    fun listVersions(
        params: ClientListVersionsParams = ClientListVersionsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see listVersions */
    fun listVersions(params: ClientListVersionsParams = ClientListVersionsParams.none()) =
        listVersions(params, RequestOptions.none())

    /** @see listVersions */
    fun listVersions(requestOptions: RequestOptions) =
        listVersions(ClientListVersionsParams.none(), requestOptions)

    /** Show API version details */
    fun retrieveVersionDetails() = retrieveVersionDetails(ClientRetrieveVersionDetailsParams.none())

    /** @see retrieveVersionDetails */
    fun retrieveVersionDetails(
        params: ClientRetrieveVersionDetailsParams = ClientRetrieveVersionDetailsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see retrieveVersionDetails */
    fun retrieveVersionDetails(
        params: ClientRetrieveVersionDetailsParams = ClientRetrieveVersionDetailsParams.none()
    ) = retrieveVersionDetails(params, RequestOptions.none())

    /** @see retrieveVersionDetails */
    fun retrieveVersionDetails(requestOptions: RequestOptions) =
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

    /** A view of [SpotlessClient] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpotlessClient.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /`, but is otherwise the same as
         * [SpotlessClient.listVersions].
         */
        @MustBeClosed
        fun listVersions(): HttpResponse = listVersions(ClientListVersionsParams.none())

        /** @see listVersions */
        @MustBeClosed
        fun listVersions(
            params: ClientListVersionsParams = ClientListVersionsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see listVersions */
        @MustBeClosed
        fun listVersions(
            params: ClientListVersionsParams = ClientListVersionsParams.none()
        ): HttpResponse = listVersions(params, RequestOptions.none())

        /** @see listVersions */
        @MustBeClosed
        fun listVersions(requestOptions: RequestOptions): HttpResponse =
            listVersions(ClientListVersionsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v2`, but is otherwise the same as
         * [SpotlessClient.retrieveVersionDetails].
         */
        @MustBeClosed
        fun retrieveVersionDetails(): HttpResponse =
            retrieveVersionDetails(ClientRetrieveVersionDetailsParams.none())

        /** @see retrieveVersionDetails */
        @MustBeClosed
        fun retrieveVersionDetails(
            params: ClientRetrieveVersionDetailsParams = ClientRetrieveVersionDetailsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see retrieveVersionDetails */
        @MustBeClosed
        fun retrieveVersionDetails(
            params: ClientRetrieveVersionDetailsParams = ClientRetrieveVersionDetailsParams.none()
        ): HttpResponse = retrieveVersionDetails(params, RequestOptions.none())

        /** @see retrieveVersionDetails */
        @MustBeClosed
        fun retrieveVersionDetails(requestOptions: RequestOptions): HttpResponse =
            retrieveVersionDetails(ClientRetrieveVersionDetailsParams.none(), requestOptions)
    }
}
