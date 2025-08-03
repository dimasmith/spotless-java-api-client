// File generated from our OpenAPI spec by Stainless.

package dev.knopitoshka.services.async

import dev.knopitoshka.TestServerExtension
import dev.knopitoshka.client.okhttp.SpotlessOkHttpClientAsync
import dev.knopitoshka.models.games.GameStartParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class GameServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun start() {
        val client =
            SpotlessOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val gameServiceAsync = client.games()

        val responseFuture =
            gameServiceAsync.start(
                GameStartParams.builder()
                    .playAs(GameStartParams.PlayAs.WHITE)
                    .timeControl(GameStartParams.TimeControl.BLITZ)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
