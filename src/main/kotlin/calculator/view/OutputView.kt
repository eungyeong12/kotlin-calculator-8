package calculator.view

import calculator.constant.Constants.CALCULATOR_RESULT_MESSAGE
import calculator.constant.Constants.CALCULATOR_START_MESSAGE
import java.math.BigInteger

class OutputView {
    fun displayCalculatorStartMessage() {
        println(CALCULATOR_START_MESSAGE)
    }

    fun displayCalculateResult(sum: BigInteger) {
        println("$CALCULATOR_RESULT_MESSAGE $sum")
    }
}
