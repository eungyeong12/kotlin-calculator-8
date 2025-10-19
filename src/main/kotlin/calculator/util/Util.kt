package calculator.util

import calculator.constant.Constants.CUSTOM_DELIMITER_SETTING_REGEX

object Util {
    fun isExistCustomDelimiter(input: String): Boolean {
        return input.startsWith(CUSTOM_DELIMITER_SETTING_REGEX)
    }
}