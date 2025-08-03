// File generated from our OpenAPI spec by Stainless.

package dev.knopitoshka.models.games

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dev.knopitoshka.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GameStartResponseTest {

    @Test
    fun create() {
        val gameStartResponse = GameStartResponse.builder().gameId("gameId").build()

        assertThat(gameStartResponse.gameId()).contains("gameId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val gameStartResponse = GameStartResponse.builder().gameId("gameId").build()

        val roundtrippedGameStartResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(gameStartResponse),
                jacksonTypeRef<GameStartResponse>(),
            )

        assertThat(roundtrippedGameStartResponse).isEqualTo(gameStartResponse)
    }
}
