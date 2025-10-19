package calculator.domain.calculator

import calculator.domain.number.Numbers
import java.math.BigInteger

class Calculator private constructor(
    private val numbers: Numbers
) {
    fun calculate(): BigInteger {
        return numbers.getNumbers().sumOf { it }
    }

    companion object {
        fun of(numbers: Numbers): Calculator {
            return Calculator(numbers)
        }
    }
}