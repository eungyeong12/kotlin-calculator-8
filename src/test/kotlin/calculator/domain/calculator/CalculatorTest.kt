package calculator.domain.calculator

import calculator.domain.number.Numbers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigInteger
import java.util.stream.Stream

class CalculatorTest {

    @ParameterizedTest(name = "입력: {0}, 결과: {1}")
    @MethodSource("provideInputAndResult")
    @DisplayName("입력값에 대해 올바른 합을 반환한다")
    fun testReturnsCorrectSum(numbers: Numbers, expected: BigInteger) {
        assertEquals(expected, Calculator.of(numbers).calculate())
    }

    companion object {
        @JvmStatic
        fun provideInputAndResult(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Numbers.from(listOf("2", "2", "2", "10")), 16.toBigInteger()),
                Arguments.of(Numbers.from(listOf("1", "2", "3", "4", "5")), 15.toBigInteger())
            )
        }
    }
}