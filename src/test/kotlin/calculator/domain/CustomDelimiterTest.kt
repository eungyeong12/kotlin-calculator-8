package calculator.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CustomDelimiterTest {

    @Test
    fun `입력값에 커스텀 구분자가 존재하는 경우, value가 존재한다`() {
        // given
        val input = "//;\\n1"

        // when
        val customDelimiter = CustomDelimiter.from(input)

        // then
        assertEquals(customDelimiter.value, ';')
    }

    @Test
    fun `입력값에 커스텀 구분자가 존재하지 않는 경우, value가 null이다`() {
        // given
        val input = "12345"

        // when
        val customDelimiter = CustomDelimiter.from(input)

        // then
        assertEquals(customDelimiter.value, null)
    }
}