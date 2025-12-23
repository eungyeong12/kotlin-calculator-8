package calculator.controller

import calculator.view.InputView
import calculator.view.OutputView

class CalculatorController {
    fun run() {
        OutputView.displayInputPrompt()
        InputView.readInput()
    }
}