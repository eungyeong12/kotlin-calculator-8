package calculator.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumbersTest {

    @Test
    fun `숫자로 변환될 수 있는 입력이 주어질 경우 올바르게 Numbers 객체가 생성된다`() {
        // given
        val input = "//;\\n1,2:3;4"
        val delimiters = Delimiters.from(input)

        // when
        val numbers = Numbers.from(input, delimiters).numbers

        // then
        assertEquals(numbers.size, 4)
        assertEquals(numbers[0], 1)
        assertEquals(numbers[1], 2)
        assertEquals(numbers[2], 3)
        assertEquals(numbers[3], 4)
    }

    @Test
    fun `숫자로 변환될 수 없는 입력이 주어질 경우 에러 메시지가 던져진다`() {
        // given
        val input = "//;\\n1,2asef:3;4"
        val delimiters = Delimiters.from(input)

        // when
        val exception = assertThrows<IllegalArgumentException> { Numbers.from(input, delimiters).numbers }

        // then
        assertEquals(exception.message, "구분자 이외의 문자가 포함되어 있습니다.")
    }
}