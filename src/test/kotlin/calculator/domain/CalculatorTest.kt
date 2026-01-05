package calculator.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `입력값과 구분자가 주어지면 정상적으로 Calculator 객체를 생성한다`() {
        // given
        val input = "//.\\n1.2.3:4,5.6"
        val delimiters = Delimiters.from(input)

        // when
        val calculator = Calculator.from(input, delimiters)

        // then
        assertEquals(listOf(1, 2, 3, 4, 5, 6), calculator.numbers)
    }
}