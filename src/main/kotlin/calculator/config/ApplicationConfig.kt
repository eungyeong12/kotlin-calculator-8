package calculator.config

import calculator.controller.StringAdditionCalculator
import calculator.view.OutputView

class ApplicationConfig {
    fun stringAdditionCalculator(): StringAdditionCalculator =
        StringAdditionCalculator(OutputView())
}