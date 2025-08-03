// File generated from our OpenAPI spec by Stainless.

package dev.knopitoshka.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dev.knopitoshka.client.okhttp.SpotlessOkHttpClient
import dev.knopitoshka.core.jsonMapper
import dev.knopitoshka.models.games.GameStartResponse
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            // We have to manually run the test methods instead of using the JUnit runner because it
            // seems impossible to get working with R8.
            val test = ProGuardCompatibilityTest()
            test::class
                .memberFunctions
                .asSequence()
                .filter { function ->
                    function.javaMethod?.isAnnotationPresent(Test::class.java) == true
                }
                .forEach { it.call(test) }
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream("META-INF/proguard/spotless-java-core.pro")

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client = SpotlessOkHttpClient.builder().apiKey("My API Key").build()

        assertThat(client).isNotNull()
        assertThat(client.games()).isNotNull()
    }

    @Test
    fun gameStartResponseRoundtrip() {
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
