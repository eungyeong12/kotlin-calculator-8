package calculator.config

import calculator.controller.StringAdditionCalculatorController
import calculator.service.calculator.CalculatorService
import calculator.service.delimiter.DelimiterService
import calculator.service.number.NumberService
import calculator.view.InputView
import calculator.view.OutputView

class ApplicationConfig {
    fun stringAdditionCalculatorController(): StringAdditionCalculatorController =
        StringAdditionCalculatorController(
            InputView(),
            OutputView(),
            DelimiterService(),
            NumberService(),
            CalculatorService()
        )
}