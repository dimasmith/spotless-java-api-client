// File generated from our OpenAPI spec by Stainless.

package dev.knopitoshka.models.games

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dev.knopitoshka.core.ExcludeMissing
import dev.knopitoshka.core.JsonField
import dev.knopitoshka.core.JsonMissing
import dev.knopitoshka.core.JsonValue
import dev.knopitoshka.errors.SpotlessInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

class GameStartResponse
private constructor(
    private val gameId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("gameId") @ExcludeMissing gameId: JsonField<String> = JsonMissing.of()
    ) : this(gameId, mutableMapOf())

    /**
     * Unique identifier for the game
     *
     * @throws SpotlessInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun gameId(): Optional<String> = gameId.getOptional("gameId")

    /**
     * Returns the raw JSON value of [gameId].
     *
     * Unlike [gameId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("gameId") @ExcludeMissing fun _gameId(): JsonField<String> = gameId

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [GameStartResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [GameStartResponse]. */
    class Builder internal constructor() {

        private var gameId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(gameStartResponse: GameStartResponse) = apply {
            gameId = gameStartResponse.gameId
            additionalProperties = gameStartResponse.additionalProperties.toMutableMap()
        }

        /** Unique identifier for the game */
        fun gameId(gameId: String) = gameId(JsonField.of(gameId))

        /**
         * Sets [Builder.gameId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.gameId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun gameId(gameId: JsonField<String>) = apply { this.gameId = gameId }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [GameStartResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): GameStartResponse =
            GameStartResponse(gameId, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): GameStartResponse = apply {
        if (validated) {
            return@apply
        }

        gameId()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: SpotlessInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic internal fun validity(): Int = (if (gameId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is GameStartResponse && gameId == other.gameId && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(gameId, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "GameStartResponse{gameId=$gameId, additionalProperties=$additionalProperties}"
}
