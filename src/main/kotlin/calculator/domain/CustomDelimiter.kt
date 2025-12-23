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
            val matchResult = delimiterRegex.find(input)
            if (matchResult != null) {
                return matchResult.groupValues[1].first()
            }
            return null
        }
    }
}