package calculator.exception

enum class ErrorMessage(val message: String) {
    INVALID_INPUT("잘못된 형식을 입력하였습니다."),
    LESS_THAN_ZERO("[ERROR] 각 숫자는 0 이상이어야 합니다.");

    val errorMessage: String get() = "[ERROR] $message"
}