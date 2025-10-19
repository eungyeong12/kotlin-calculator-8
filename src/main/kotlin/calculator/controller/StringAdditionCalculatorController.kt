package calculator.controller

import calculator.service.delimiter.DelimiterService
import calculator.service.number.NumberService
import calculator.view.InputView
import calculator.view.OutputView

class StringAdditionCalculatorController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val delimiterService: DelimiterService,
    private val numberService: NumberService
) {
    fun run() {
        outputView.displayCalculatorStartMessage()
        val input = inputView.readInput()

        val delimiters = delimiterService.getDelimiters(input)
        numberService.getNumbers(input, delimiters)
    }
}