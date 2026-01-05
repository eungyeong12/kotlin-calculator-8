package calculator.domain

import calculator.constant.Constants.REGEX
import calculator.exception.ErrorMessage
import calculator.parser.Parser.parseToNumber

data class Calculator(
    val numbers: List<Int>
) {
    fun sum() = numbers.sum()

    companion object {
        fun from(input: String, delimiters: Delimiters): Calculator {
            if (REGEX.containsMatchIn(input)) {
                val tokens = splitByDelimiters(REGEX.replace(input, ""), delimiters)
                return Calculator(parseToNumbers(tokens))
            }
            return Calculator(parseToNumbers(splitByDelimiters(input, delimiters)))
        }

        private fun splitByDelimiters(input: String, delimiters: Delimiters): List<String> {
            return input.split(*delimiters.value.toTypedArray())
        }

        private fun parseToNumbers(tokens: List<String>): List<Int> {
            return tokens.map {
                val number = parseToNumber(it)
                require(number >= 0) {
                    ErrorMessage.LESS_THAN_ZERO.errorMessage
                }
                number
            }
        }
    }
}