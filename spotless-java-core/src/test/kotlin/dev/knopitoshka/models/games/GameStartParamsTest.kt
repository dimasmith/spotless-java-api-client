// File generated from our OpenAPI spec by Stainless.

package dev.knopitoshka.models.games

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GameStartParamsTest {

    @Test
    fun create() {
        GameStartParams.builder()
            .playAs(GameStartParams.PlayAs.WHITE)
            .timeControl(GameStartParams.TimeControl.BLITZ)
            .build()
    }

    @Test
    fun body() {
        val params =
            GameStartParams.builder()
                .playAs(GameStartParams.PlayAs.WHITE)
                .timeControl(GameStartParams.TimeControl.BLITZ)
                .build()

        val body = params._body()

        assertThat(body.playAs()).contains(GameStartParams.PlayAs.WHITE)
        assertThat(body.timeControl()).contains(GameStartParams.TimeControl.BLITZ)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = GameStartParams.builder().build()

        val body = params._body()
    }
}
