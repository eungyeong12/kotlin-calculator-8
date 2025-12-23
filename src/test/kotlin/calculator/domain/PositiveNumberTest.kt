package calculator.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PositiveNumberTest {

    @Test
    fun `양수가 입력될 경우 정상적으로 PositiveNumber 객체가 생성된다`() {
        // given
        val input = 100

        // when
        val number = PositiveNumber(input)

        // then
        assertEquals(number.value, 100)
    }

    @Test
    fun `양수가 아닌 수가 입력될 경우 에러 메시지가 던져진다`() {
        // given
        val input = -100

        // when
        val exception = assertThrows<IllegalArgumentException> { PositiveNumber(input) }

        // then
        assertEquals(exception.message, "양수가 아닌 수가 포함되어 있습니다.")
    }
}