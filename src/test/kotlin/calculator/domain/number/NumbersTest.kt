package calculator.domain.number

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

class NumbersTest {

    @ParameterizedTest(name = "입력: {0}, 결과: {1}")
    @MethodSource("provideSuccessInputAndResult")
    @DisplayName("문자열 리스트를 성공적으로 숫자 리스트로 변환한다")
    fun testParseNumbersSuccess(tokens: List<String>, expected: List<BigInteger>) {
        val actual = Numbers.from(tokens).getNumbers()
        assertEquals(actual, expected)
    }

    @ParameterizedTest(name = "입력: {0}")
    @MethodSource("provideFailInputAndResult")
    @DisplayName("문자열 리스트를 숫자 리스트로 변환하는 데 실패한다")
    fun testParseNumbersFail(tokens: List<String>) {
        val e = assertThrows<ValidationException> { Numbers.from(tokens).getNumbers() }
        assertTrue(e.message!!.contains(ExceptionMessage.INVALID_NON_DELIMITER_CHARACTER.message))
    }

    companion object {
        @JvmStatic
        fun provideSuccessInputAndResult(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf("56", "2", "2", "10"), listOf(56, 2, 2, 10).map { it.toBigInteger() }),
                Arguments.of(listOf("2", "34", "24", "22"), listOf(2, 34, 24, 22).map { it.toBigInteger() }),
                Arguments.of(listOf("2", "3", "34", "24", "100"), listOf(2, 3, 34, 24, 100).map { it.toBigInteger() })
            )
        }

        @JvmStatic
        fun provideFailInputAndResult(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf("-56", "2", "2", "10"), listOf(56, 2, 2, 10).map { it.toBigInteger() }),
                Arguments.of(listOf("2", "34", "-24", "22"), listOf(2, 34, 24, 22).map { it.toBigInteger() }),
                Arguments.of(listOf("2", "-3", "34", "24", "100"), listOf(2, 3, 34, 24, 100).map { it.toBigInteger() })
            )
        }
    }
}