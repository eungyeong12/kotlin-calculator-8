package calculator.domain

import calculator.constant.Constants.delimiterRegex

@JvmInline
value class CustomDelimiter private constructor(
    val value: Char?
) {
    companion object {
        fun from(input: String): CustomDelimiter {
            val value = extractCustomDelimiter(input)
            return CustomDelimiter(value)
        }

        private fun extractCustomDelimiter(input: String): Char? {
            return delimiterRegex.find(input)?.groupValues[1]?.firstOrNull()
        }
    }
}