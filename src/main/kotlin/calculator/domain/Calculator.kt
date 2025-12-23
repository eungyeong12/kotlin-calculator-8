package calculator.domain

class Calculator(val numbers: Numbers) {
    fun sum(): Int {
        return numbers.sum()
    }
}