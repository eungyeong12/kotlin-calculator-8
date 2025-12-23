package calculator.domain

import calculator.constant.Constants.delimiterRegex
import calculator.exception.ErrorMessage

class Numbers private constructor(
    val numbers: List<Int>
) {

    fun sum(): Int {
        return numbers.sum()
    }

    companion object {
        fun from(input: String, delimiters: Delimiters): Numbers {
            val tokens = splitByDelimiters(removeDelimiterHeader(input), delimiters)
            return Numbers(toNumbers(tokens))
        }

        private fun removeDelimiterHeader(input: String): String {
            return delimiterRegex.replaceFirst(input, "")
        }

        private fun splitByDelimiters(input: String, delimiters: Delimiters): List<String> {
            return input.split(*delimiters.delimiters.toCharArray())
        }

        private fun toNumbers(tokens: List<String>): List<Int> {
            return tokens.map { token ->
                val number = token.toIntOrNull()
                requireNotNull(number) { ErrorMessage.NOT_CONVERTED_TO_AN_INTEGER.message }
                PositiveNumber(number).value
            }
        }
    }
}