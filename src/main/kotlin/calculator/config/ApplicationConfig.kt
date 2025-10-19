package calculator.config

import calculator.controller.StringAdditionCalculatorController
import calculator.service.delimiter.DelimiterService
import calculator.view.InputView
import calculator.view.OutputView

class ApplicationConfig {
    fun stringAdditionCalculatorController(): StringAdditionCalculatorController =
        StringAdditionCalculatorController(InputView(), OutputView(), DelimiterService())
}