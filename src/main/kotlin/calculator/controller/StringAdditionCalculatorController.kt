package calculator.controller

import calculator.service.delimiter.DelimiterService
import calculator.view.InputView
import calculator.view.OutputView

class StringAdditionCalculatorController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val delimiterService: DelimiterService
) {
    fun run() {
        outputView.displayCalculatorStartMessage()
        val input = inputView.readInput()
        delimiterService.getDelimiters(input)
    }
}