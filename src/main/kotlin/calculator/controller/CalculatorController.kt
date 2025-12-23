package calculator.controller

import calculator.domain.Delimiters
import calculator.view.InputView
import calculator.view.OutputView

class CalculatorController {
    fun run() {
        OutputView.displayInputPrompt()
        val input = InputView.readInput()
        Delimiters.from(input)
    }
}