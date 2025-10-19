package calculator

import calculator.config.ApplicationConfig

fun main() {
    val stringAdditionCalculatorController = ApplicationConfig().stringAdditionCalculatorController()
    stringAdditionCalculatorController.run()
}