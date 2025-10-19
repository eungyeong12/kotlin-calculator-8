package calculator.view

import calculator.constant.Constants.ZERO
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readInput(): String {
        val input = Console.readLine().trim()
        if (input.isEmpty()) {
            return ZERO
        }
        return input
    }
}