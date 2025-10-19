package calculator

import calculator.config.ApplicationConfig

fun main() {
    val stringAdditionController = ApplicationConfig().stringAdditionCalculator()
    stringAdditionController.run()
}