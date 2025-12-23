package calculator.exception

enum class ErrorMessage(val message: String) {
    NOT_CONVERTED_TO_AN_INTEGER("구분자 이외의 문자가 포함되어 있습니다."),
    NOT_POSITIVE_NUMBER("양수가 아닌 수가 포함되어 있습니다.")
}