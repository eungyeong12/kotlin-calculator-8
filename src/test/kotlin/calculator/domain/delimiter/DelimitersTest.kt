package calculator.domain.delimiter

import calculator.constant.Constants
import org.junit.jupiter.api.Assertions
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
        val delimiters = Delimiters.create()

        // when
        val actual = delimiters.getDelimiters()

        // then
        Assertions.assertTrue(actual.contains(Constants.COMMA))
        Assertions.assertTrue(actual.contains(Constants.COLON))
        Assertions.assertEquals(2, actual.size)
    }

    @ParameterizedTest(name = "입력: {0}, 결과: {1}")
    @MethodSource("provideUniqueCustomDelimiter")
    @DisplayName("of(custom)는 기본 구분자와 커스텀 구분자를 포함한다.")
    fun testOfAddsCustom(delimiter: Char, expected: Char) {
        val actual = Delimiters.of(delimiter).getDelimiters()
        Assertions.assertTrue(actual.contains(expected))
        Assertions.assertEquals(3, actual.size)
    }

    @ParameterizedTest(name = "입력: {0}, 결과: {1}")
    @MethodSource("provideDefaultDelimiter")
    @DisplayName("커스텀 구분자가 기본 구분자와 동일해도 중복 없이 유지된다")
    fun testDuplicateCustomIsIgnored(delimiter: Char, expected: Int) {
        val actual = Delimiters.of(delimiter).getDelimiters()
        Assertions.assertEquals(expected, actual.size)
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
                Arguments.of(Constants.COMMA, 2),
                Arguments.of(Constants.COLON, 2)
            )
        }
    }
}