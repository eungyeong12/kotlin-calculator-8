package calculator.service.delimiter

import calculator.domain.delimiter.CustomDelimiter
import calculator.domain.delimiter.Delimiters
import calculator.util.Util.isExistCustomDelimiter

class DelimiterService {
    fun getDelimiters(input: String): Delimiters {
        if (isExistCustomDelimiter(input)) {
            val customDelimiter = CustomDelimiter.from(input)
            return Delimiters.of(customDelimiter.getCustomDelimiter())
        }
        return Delimiters.default()
    }
}