package calculator.controller

import calculator.view.InputView
import calculator.view.OutputView

class StringAdditionCalculatorController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun run() {
        outputView.displayCalculatorStartMessage()
        inputView.readInput()
    }
}