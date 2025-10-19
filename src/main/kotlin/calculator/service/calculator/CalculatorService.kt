package calculator.service.calculator

import calculator.domain.calculator.Calculator
import calculator.domain.number.Numbers
import java.math.BigInteger

class CalculatorService {
    fun calculate(numbers: Numbers): BigInteger {
        val calculator = Calculator.of(numbers)
        return calculator.calculate()
    }
}