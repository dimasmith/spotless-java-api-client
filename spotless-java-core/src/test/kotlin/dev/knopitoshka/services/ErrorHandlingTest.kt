// File generated from our OpenAPI spec by Stainless.

package dev.knopitoshka.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import dev.knopitoshka.client.SpotlessClient
import dev.knopitoshka.client.okhttp.SpotlessOkHttpClient
import dev.knopitoshka.core.JsonValue
import dev.knopitoshka.core.http.Headers
import dev.knopitoshka.core.jsonMapper
import dev.knopitoshka.errors.BadRequestException
import dev.knopitoshka.errors.InternalServerException
import dev.knopitoshka.errors.NotFoundException
import dev.knopitoshka.errors.PermissionDeniedException
import dev.knopitoshka.errors.RateLimitException
import dev.knopitoshka.errors.SpotlessException
import dev.knopitoshka.errors.UnauthorizedException
import dev.knopitoshka.errors.UnexpectedStatusCodeException
import dev.knopitoshka.errors.UnprocessableEntityException
import dev.knopitoshka.models.games.GameStartParams
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ErrorHandlingTest {

    companion object {

        private val ERROR_JSON: JsonValue = JsonValue.from(mapOf("errorProperty" to "42"))

        private val ERROR_JSON_BYTES: ByteArray = jsonMapper().writeValueAsBytes(ERROR_JSON)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

    private lateinit var client: SpotlessClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            SpotlessOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun gamesStart400() {
        val gameService = client.games()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                gameService.start(
                    GameStartParams.builder()
                        .playAs(GameStartParams.PlayAs.WHITE)
                        .timeControl(GameStartParams.TimeControl.BLITZ)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun gamesStart400WithRawResponse() {
        val gameService = client.games().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                gameService.start(
                    GameStartParams.builder()
                        .playAs(GameStartParams.PlayAs.WHITE)
                        .timeControl(GameStartParams.TimeControl.BLITZ)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun gamesStart401() {
        val gameService = client.games()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                gameService.start(
                    GameStartParams.builder()
                        .playAs(GameStartParams.PlayAs.WHITE)
                        .timeControl(GameStartParams.TimeControl.BLITZ)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun gamesStart401WithRawResponse() {
        val gameService = client.games().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                gameService.start(
                    GameStartParams.builder()
                        .playAs(GameStartParams.PlayAs.WHITE)
                        .timeControl(GameStartParams.TimeControl.BLITZ)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun gamesStart403() {
        val gameService = client.games()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                gameService.start(
                    GameStartParams.builder()
                        .playAs(GameStartParams.PlayAs.WHITE)
                        .timeControl(GameStartParams.TimeControl.BLITZ)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun gamesStart403WithRawResponse() {
        val gameService = client.games().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                gameService.start(
                    GameStartParams.builder()
                        .playAs(GameStartParams.PlayAs.WHITE)
                        .timeControl(GameStartParams.TimeControl.BLITZ)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun gamesStart404() {
        val gameService = client.games()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                gameService.start(
                    GameStartParams.builder()
                        .playAs(GameStartParams.PlayAs.WHITE)
                        .timeControl(GameStartParams.TimeControl.BLITZ)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun gamesStart404WithRawResponse() {
        val gameService = client.games().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                gameService.start(
                    GameStartParams.builder()
                        .playAs(GameStartParams.PlayAs.WHITE)
                        .timeControl(GameStartParams.TimeControl.BLITZ)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun gamesStart422() {
        val gameService = client.games()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                gameService.start(
                    GameStartParams.builder()
                        .playAs(GameStartParams.PlayAs.WHITE)
                        .timeControl(GameStartParams.TimeControl.BLITZ)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun gamesStart422WithRawResponse() {
        val gameService = client.games().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                gameService.start(
                    GameStartParams.builder()
                        .playAs(GameStartParams.PlayAs.WHITE)
                        .timeControl(GameStartParams.TimeControl.BLITZ)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun gamesStart429() {
        val gameService = client.games()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                gameService.start(
                    GameStartParams.builder()
                        .playAs(GameStartParams.PlayAs.WHITE)
                        .timeControl(GameStartParams.TimeControl.BLITZ)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun gamesStart429WithRawResponse() {
        val gameService = client.games().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                gameService.start(
                    GameStartParams.builder()
                        .playAs(GameStartParams.PlayAs.WHITE)
                        .timeControl(GameStartParams.TimeControl.BLITZ)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun gamesStart500() {
        val gameService = client.games()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                gameService.start(
                    GameStartParams.builder()
                        .playAs(GameStartParams.PlayAs.WHITE)
                        .timeControl(GameStartParams.TimeControl.BLITZ)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun gamesStart500WithRawResponse() {
        val gameService = client.games().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                gameService.start(
                    GameStartParams.builder()
                        .playAs(GameStartParams.PlayAs.WHITE)
                        .timeControl(GameStartParams.TimeControl.BLITZ)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun gamesStart999() {
        val gameService = client.games()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                gameService.start(
                    GameStartParams.builder()
                        .playAs(GameStartParams.PlayAs.WHITE)
                        .timeControl(GameStartParams.TimeControl.BLITZ)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun gamesStart999WithRawResponse() {
        val gameService = client.games().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                gameService.start(
                    GameStartParams.builder()
                        .playAs(GameStartParams.PlayAs.WHITE)
                        .timeControl(GameStartParams.TimeControl.BLITZ)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun gamesStartInvalidJsonBody() {
        val gameService = client.games()
        stubFor(
            post(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<SpotlessException> {
                gameService.start(
                    GameStartParams.builder()
                        .playAs(GameStartParams.PlayAs.WHITE)
                        .timeControl(GameStartParams.TimeControl.BLITZ)
                        .build()
                )
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
