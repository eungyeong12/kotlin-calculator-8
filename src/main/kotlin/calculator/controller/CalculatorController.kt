package calculator.controller

import calculator.domain.Calculator
import calculator.domain.Delimiters
import calculator.domain.Numbers
import calculator.view.InputView
import calculator.view.OutputView

class CalculatorController {
    fun run() {
        OutputView.displayInputPrompt()
        val input = InputView.readInput()
        val delimiters = Delimiters.from(input)
        val numbers = Numbers.from(input, delimiters)
        val calculator = Calculator(numbers)
        OutputView.displayResult(calculator.sum())
    }
}