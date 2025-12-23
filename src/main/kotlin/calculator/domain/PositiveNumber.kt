package calculator.domain

import calculator.exception.ErrorMessage

@JvmInline
value class PositiveNumber(
    val value: Int
) {
    init {
        require(value >= 0) { ErrorMessage.NOT_POSITIVE_NUMBER.message }
    }
}