package calculator.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DelimitersTest {

    @Test
    fun `입력값에 기본 구분자와 중복되지 않는 커스텀 구분자가 존재하는 경우, 커스텀 구분자를 포함하여 3개의 구분자가 Set에 포함된다`() {
        // given
        val input = "//;\\n1"

        // when
        val delimiters = Delimiters.from(input).delimiters

        // then
        assertEquals(delimiters.size, 3)
        assertEquals(delimiters.contains(';'), true)
    }

    @Test
    fun `입력값에 커스텀 구분자가 존재하지 않는 경우, 기본 구분자만 포함된 List가 생성된다`() {
        // given
        val input = "123456"

        // when
        val delimiters = Delimiters.from(input).delimiters

        // then
        assertEquals(delimiters.size, 2)
        assertEquals(delimiters.contains(','), true)
        assertEquals(delimiters.contains(':'), true)
    }
}