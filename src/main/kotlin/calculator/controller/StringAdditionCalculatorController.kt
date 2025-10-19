package calculator.controller

import calculator.service.calculator.CalculatorService
import calculator.service.delimiter.DelimiterService
import calculator.service.number.NumberService
import calculator.view.InputView
import calculator.view.OutputView

class StringAdditionCalculatorController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val delimiterService: DelimiterService,
    private val numberService: NumberService,
    private val calculatorService: CalculatorService
) {
    fun run() {
        outputView.displayCalculatorStartMessage()
        val input = inputView.readInput()

        val delimiters = delimiterService.getDelimiters(input)
        val numbers = numberService.getNumbers(input, delimiters)
        val sum = calculatorService.calculate(numbers)

        outputView.displayCalculateResult(sum)
    }
}