package calculator.domain.delimiter

import calculator.constant.Constants.CUSTOM_DELIMITER_INDEX

class CustomDelimiter private constructor(
    private val delimiter: Char
) {
    fun getCustomDelimiter(): Char {
        return delimiter
    }

    companion object {
        fun from(input: String): CustomDelimiter {
            val delimiter = input[CUSTOM_DELIMITER_INDEX]
            return CustomDelimiter(delimiter)
        }
    }
}