package calculator.controller

import calculator.view.OutputView

class StringAdditionCalculator(
    private val outputView: OutputView
) {
    fun run() {
        outputView.displayCalculatorStartMessage()
    }
}