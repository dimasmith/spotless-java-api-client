// File generated from our OpenAPI spec by Stainless.

package dev.knopitoshka.models.games

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dev.knopitoshka.core.Enum
import dev.knopitoshka.core.ExcludeMissing
import dev.knopitoshka.core.JsonField
import dev.knopitoshka.core.JsonMissing
import dev.knopitoshka.core.JsonValue
import dev.knopitoshka.core.Params
import dev.knopitoshka.core.http.Headers
import dev.knopitoshka.core.http.QueryParams
import dev.knopitoshka.errors.SpotlessInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Starts a new game of chess. */
class GameStartParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Piece color to play as (e.g., 'white' or 'black')
     *
     * @throws SpotlessInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun playAs(): Optional<PlayAs> = body.playAs()

    /**
     * Time control for the game (e.g., 'blitz', 'rapid', 'classical')
     *
     * @throws SpotlessInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun timeControl(): Optional<TimeControl> = body.timeControl()

    /**
     * Returns the raw JSON value of [playAs].
     *
     * Unlike [playAs], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _playAs(): JsonField<PlayAs> = body._playAs()

    /**
     * Returns the raw JSON value of [timeControl].
     *
     * Unlike [timeControl], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _timeControl(): JsonField<TimeControl> = body._timeControl()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): GameStartParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [GameStartParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [GameStartParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(gameStartParams: GameStartParams) = apply {
            body = gameStartParams.body.toBuilder()
            additionalHeaders = gameStartParams.additionalHeaders.toBuilder()
            additionalQueryParams = gameStartParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [playAs]
         * - [timeControl]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Piece color to play as (e.g., 'white' or 'black') */
        fun playAs(playAs: PlayAs) = apply { body.playAs(playAs) }

        /**
         * Sets [Builder.playAs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.playAs] with a well-typed [PlayAs] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun playAs(playAs: JsonField<PlayAs>) = apply { body.playAs(playAs) }

        /** Time control for the game (e.g., 'blitz', 'rapid', 'classical') */
        fun timeControl(timeControl: TimeControl) = apply { body.timeControl(timeControl) }

        /**
         * Sets [Builder.timeControl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.timeControl] with a well-typed [TimeControl] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun timeControl(timeControl: JsonField<TimeControl>) = apply {
            body.timeControl(timeControl)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [GameStartParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): GameStartParams =
            GameStartParams(body.build(), additionalHeaders.build(), additionalQueryParams.build())
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val playAs: JsonField<PlayAs>,
        private val timeControl: JsonField<TimeControl>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("playAs") @ExcludeMissing playAs: JsonField<PlayAs> = JsonMissing.of(),
            @JsonProperty("timeControl")
            @ExcludeMissing
            timeControl: JsonField<TimeControl> = JsonMissing.of(),
        ) : this(playAs, timeControl, mutableMapOf())

        /**
         * Piece color to play as (e.g., 'white' or 'black')
         *
         * @throws SpotlessInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun playAs(): Optional<PlayAs> = playAs.getOptional("playAs")

        /**
         * Time control for the game (e.g., 'blitz', 'rapid', 'classical')
         *
         * @throws SpotlessInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun timeControl(): Optional<TimeControl> = timeControl.getOptional("timeControl")

        /**
         * Returns the raw JSON value of [playAs].
         *
         * Unlike [playAs], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("playAs") @ExcludeMissing fun _playAs(): JsonField<PlayAs> = playAs

        /**
         * Returns the raw JSON value of [timeControl].
         *
         * Unlike [timeControl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("timeControl")
        @ExcludeMissing
        fun _timeControl(): JsonField<TimeControl> = timeControl

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var playAs: JsonField<PlayAs> = JsonMissing.of()
            private var timeControl: JsonField<TimeControl> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                playAs = body.playAs
                timeControl = body.timeControl
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Piece color to play as (e.g., 'white' or 'black') */
            fun playAs(playAs: PlayAs) = playAs(JsonField.of(playAs))

            /**
             * Sets [Builder.playAs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.playAs] with a well-typed [PlayAs] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun playAs(playAs: JsonField<PlayAs>) = apply { this.playAs = playAs }

            /** Time control for the game (e.g., 'blitz', 'rapid', 'classical') */
            fun timeControl(timeControl: TimeControl) = timeControl(JsonField.of(timeControl))

            /**
             * Sets [Builder.timeControl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.timeControl] with a well-typed [TimeControl] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun timeControl(timeControl: JsonField<TimeControl>) = apply {
                this.timeControl = timeControl
            }

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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body = Body(playAs, timeControl, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            playAs().ifPresent { it.validate() }
            timeControl().ifPresent { it.validate() }
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (playAs.asKnown().getOrNull()?.validity() ?: 0) +
                (timeControl.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && playAs == other.playAs && timeControl == other.timeControl && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(playAs, timeControl, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{playAs=$playAs, timeControl=$timeControl, additionalProperties=$additionalProperties}"
    }

    /** Piece color to play as (e.g., 'white' or 'black') */
    class PlayAs @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val WHITE = of("white")

            @JvmField val BLACK = of("black")

            @JvmField val RANDOM = of("random")

            @JvmStatic fun of(value: String) = PlayAs(JsonField.of(value))
        }

        /** An enum containing [PlayAs]'s known values. */
        enum class Known {
            WHITE,
            BLACK,
            RANDOM,
        }

        /**
         * An enum containing [PlayAs]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [PlayAs] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            WHITE,
            BLACK,
            RANDOM,
            /** An enum member indicating that [PlayAs] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                WHITE -> Value.WHITE
                BLACK -> Value.BLACK
                RANDOM -> Value.RANDOM
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws SpotlessInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                WHITE -> Known.WHITE
                BLACK -> Known.BLACK
                RANDOM -> Known.RANDOM
                else -> throw SpotlessInvalidDataException("Unknown PlayAs: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws SpotlessInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                SpotlessInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): PlayAs = apply {
            if (validated) {
                return@apply
            }

            known()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is PlayAs && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Time control for the game (e.g., 'blitz', 'rapid', 'classical') */
    class TimeControl @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val BLITZ = of("blitz")

            @JvmField val RAPID = of("rapid")

            @JvmField val CLASSICAL = of("classical")

            @JvmStatic fun of(value: String) = TimeControl(JsonField.of(value))
        }

        /** An enum containing [TimeControl]'s known values. */
        enum class Known {
            BLITZ,
            RAPID,
            CLASSICAL,
        }

        /**
         * An enum containing [TimeControl]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [TimeControl] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            BLITZ,
            RAPID,
            CLASSICAL,
            /**
             * An enum member indicating that [TimeControl] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                BLITZ -> Value.BLITZ
                RAPID -> Value.RAPID
                CLASSICAL -> Value.CLASSICAL
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws SpotlessInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                BLITZ -> Known.BLITZ
                RAPID -> Known.RAPID
                CLASSICAL -> Known.CLASSICAL
                else -> throw SpotlessInvalidDataException("Unknown TimeControl: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws SpotlessInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                SpotlessInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): TimeControl = apply {
            if (validated) {
                return@apply
            }

            known()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is TimeControl && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is GameStartParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "GameStartParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
