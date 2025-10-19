package calculator.service.number

import calculator.constant.Constants.COMMA
import calculator.domain.delimiter.Delimiters
import calculator.exception.ExceptionMessage
import calculator.exception.ValidationException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigInteger
import java.util.stream.Stream

class NumberServiceTest {

    private val numberService = NumberService()

    @ParameterizedTest(name = "입력: {0}, 구분자: {1}, 결과: {2}")
    @MethodSource("provideValidInputAndResult")
    @DisplayName("구분자로 입력값을 분리하고, 성공적으로 숫자 리스트로 변환해 반환한다")
    fun testReturnsCorrectNumbers(input: String, delimiters: Delimiters, expected: List<BigInteger>) {
        // given
        val numbers = numberService.getNumbers(input, delimiters)

        // when
        val actual = numbers.getNumbers()

        // then
        assertEquals(expected, actual)
    }

    @ParameterizedTest(name = "입력: {0}, 구분자: {1}")
    @MethodSource("provideInValidInputAndResult")
    @DisplayName("구분자로 입력값을 분리하고, 숫자 리스트로 변환해 반환하는 데 실패한다")
    fun testReturnsIncorrectNumbers(input: String, delimiters: Delimiters) {
        val e = assertThrows<ValidationException> { numberService.getNumbers(input, delimiters) }
        assertTrue(e.message!!.contains(ExceptionMessage.INVALID_NON_DELIMITER_CHARACTER.message))
    }

    companion object {
        @JvmStatic
        fun provideValidInputAndResult(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("//#\\n56:#2,2#10", Delimiters.of('#'), listOf(56, 2, 2, 10).map { it.toBigInteger() }),
                Arguments.of("// \\n2:34,24 22", Delimiters.of(' '), listOf(2, 34, 24, 22).map { it.toBigInteger() }),
                Arguments.of("2,3,34:24,100", Delimiters.of(COMMA), listOf(2, 3, 34, 24, 100).map { it.toBigInteger() })
            )
        }

        @JvmStatic
        fun provideInValidInputAndResult(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("//#$\\n56:#$2,2#10", Delimiters.of('#')),
                Arguments.of("// \\n2:3#4,24 22", Delimiters.of(' ')),
                Arguments.of("$//$\\n2,3,3424,100", Delimiters.of(COMMA))
            )
        }
    }
}