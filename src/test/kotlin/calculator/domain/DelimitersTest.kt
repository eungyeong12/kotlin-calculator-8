package calculator.domain

import calculator.constant.Constants.COLON
import calculator.constant.Constants.COMMA
import calculator.domain.delimiter.Delimiters
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class DelimitersTest {

    @Test
    @DisplayName("기본 생성자는 기본 구분자(, :)를 가진다")
    fun testDefaultHasCommaAndColon() {
        // given
        val delimiters = Delimiters()

        // when
        val actual = delimiters.getDelimiters()

        // then
        assertTrue(actual.contains(COMMA))
        assertTrue(actual.contains(COLON))
        assertEquals(2, actual.size)
    }

    @ParameterizedTest(name = "입력: ''{0}'', 결과: {1}")
    @MethodSource("provideUniqueCustomDelimiter")
    @DisplayName("of(custom)는 기본 구분자와 커스텀 구분자를 포함한다.")
    fun testOfAddsCustom(delimiter: Char, expected: Char) {
        val actual = Delimiters.of(delimiter).getDelimiters()
        assertTrue(actual.contains(expected))
        assertEquals(3, actual.size)
    }

    @ParameterizedTest(name = "입력: ''{0}'', 결과: {1}")
    @MethodSource("provideDefaultDelimiter")
    @DisplayName("커스텀 구분자가 기본 구분자와 동일해도 중복 없이 유지된다")
    fun testDuplicateCustomIsIgnored(delimiter: Char, expected: Int) {
        val actual = Delimiters.of(delimiter).getDelimiters()
        assertEquals(expected, actual.size)
    }

    companion object {
        @JvmStatic
        fun provideUniqueCustomDelimiter(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(';', ';'),
                Arguments.of('*', '*'),
                Arguments.of('#', '#'),
                Arguments.of('@', '@')
            )
        }

        @JvmStatic
        fun provideDefaultDelimiter(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(COMMA, 2),
                Arguments.of(COLON, 2)
            )
        }
    }
}