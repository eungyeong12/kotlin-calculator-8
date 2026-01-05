package calculator.domain

import calculator.constant.Constants.DEFAULT_DELIMITERS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class DelimitersTest {

    @ParameterizedTest(name = "input={0} -> result={1}")
    @MethodSource("delimiterTestCases")
    fun `입력값에 대해 구분자들을 올바르게 추출하는지 검증한다`(input: String, expected: List<String>) {
        // when
        val delimiters = Delimiters.from(input).value

        // then
        assertEquals(expected, delimiters)
    }

    companion object {
        @JvmStatic
        fun delimiterTestCases(): Stream<Arguments> = Stream.of(
            Arguments.of("//,.;\\n1;2;3", DEFAULT_DELIMITERS),
            Arguments.of("//.\\n1;2.3", DEFAULT_DELIMITERS + listOf(".")),
            Arguments.of("// \\n1;2.3", DEFAULT_DELIMITERS + listOf(" ")),
            Arguments.of("//\\n1;2.3", DEFAULT_DELIMITERS)
        )
    }
}