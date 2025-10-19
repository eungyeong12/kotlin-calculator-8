package calculator.service.number

import calculator.constant.Constants.CUSTOM_DELIMITER_SETTING_REGEX
import calculator.domain.delimiter.Delimiters
import calculator.domain.number.Numbers
import calculator.util.Util.isExistCustomDelimiter

class NumberService {
    fun getNumbers(input: String, delimiters: Delimiters): Numbers {
        val data = removeCustomDelimiterRegex(input)
        val tokens = splitByDelimiters(data, delimiters)
        return Numbers.from(tokens)
    }

    private fun removeCustomDelimiterRegex(input: String): String {
        if (isExistCustomDelimiter(input)) {
            return input.replaceFirst(Regex(CUSTOM_DELIMITER_SETTING_REGEX), "")
        }
        return input
    }

    private fun splitByDelimiters(data: String, delimiters: Delimiters): List<String> {
        return data.split(Regex("[${delimiters.getDelimiters().joinToString()}]"))
            .filter { it.isNotBlank() }
    }
}