// File generated from our OpenAPI spec by Stainless.

package dev.knopitoshka.services.blocking

import dev.knopitoshka.TestServerExtension
import dev.knopitoshka.client.okhttp.SpotlessOkHttpClient
import dev.knopitoshka.models.games.GameStartParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class GameServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun start() {
        val client =
            SpotlessOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val gameService = client.games()

        val response =
            gameService.start(
                GameStartParams.builder()
                    .playAs(GameStartParams.PlayAs.WHITE)
                    .timeControl(GameStartParams.TimeControl.BLITZ)
                    .build()
            )

        response.validate()
    }
}
