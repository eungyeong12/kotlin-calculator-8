package calculator.domain

import calculator.domain.delimiter.CustomDelimiter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CustomDelimiterTest {

    @ParameterizedTest(name = "입력: ''{0}'', 결과: {1}")
    @MethodSource("provideInputAndResult")
    @DisplayName("커스텀 구분자를 성공적으로 추출한다")
    fun testExtractCustomDelimiter(input: String, expected: Char) {
        val actual = CustomDelimiter.of(input).getCustomDelimiter()
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun provideInputAndResult(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("//;\\n", ';'),
                Arguments.of("//:\\n", ':'),
                Arguments.of("//#\\n", '#'),
                Arguments.of("//,\\n", ',')
            )
        }
    }
}