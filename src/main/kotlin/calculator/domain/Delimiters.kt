package calculator.domain

import calculator.constant.Constants.DEFAULT_DELIMITERS
import calculator.constant.Constants.REGEX

@JvmInline
value class Delimiters(
    val value: List<String>
) {

    companion object {
        fun from(input: String): Delimiters {
            if (REGEX.containsMatchIn(input)) {
                val match = REGEX.find(input)
                return Delimiters(DEFAULT_DELIMITERS + listOf(match?.groupValues[1].toString()))
            }
            return Delimiters(DEFAULT_DELIMITERS)
        }
    }
}