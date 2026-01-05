package calculator.controller

import calculator.domain.Calculator
import calculator.domain.Delimiters
import calculator.view.InputView

class CalculatorController {

    fun run() {
        println("덧셈할 문자열을 입력해 주세요.")
        val input = InputView.readInput()
        val delimiters = Delimiters.from(input)
        val calculator = Calculator.from(input, delimiters)
        println("결과 : ${calculator.sum()}")
    }
}