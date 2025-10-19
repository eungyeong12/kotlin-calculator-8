package calculator.view

import calculator.constant.Constants.ZERO
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readInput(): String {
        return try {
            Console.readLine().trim()
        } catch (_: Exception) {
            ZERO
        }
    }
}