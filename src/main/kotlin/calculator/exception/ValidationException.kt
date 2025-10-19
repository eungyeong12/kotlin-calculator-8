package calculator.exception

class ValidationException(exceptionMessage: ExceptionMessage) :
    IllegalArgumentException(exceptionMessage.message)