package calculator.domain.delimiter

import calculator.constant.Constants

class Delimiters private constructor() {
    private val delimiters: MutableSet<Char> = mutableSetOf(Constants.COMMA, Constants.COLON)

    fun getDelimiters(): Set<Char> {
        return delimiters.toSet()
    }

    private fun addCustomDelimiter(delimiter: Char) {
        delimiters.add(delimiter)
    }

    companion object {
        fun create(): Delimiters {
            return Delimiters()
        }

        fun of(customDelimiter: Char): Delimiters {
            val delimiters = create()
            delimiters.addCustomDelimiter(customDelimiter)
            return delimiters
        }
    }
}