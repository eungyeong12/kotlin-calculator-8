package calculator.service.delimiter

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class DelimiterServiceTest {

    private val delimiterService = DelimiterService()

    @ParameterizedTest(name = "입력: {0}, 결과: {1}")
    @MethodSource("provideInputAndResult")
    @DisplayName("입력값에 대해 올바른 구분자 리스트를 반환한다")
    fun testReturnsCorrectDelimiters(input: String, expected: Int) {
        // given
        val delimiters = delimiterService.getDelimiters(input)

        // when
        val actual = delimiters.getDelimiters()

        // then
        Assertions.assertEquals(expected, actual.size)
    }

    companion object {
        @JvmStatic
        fun provideInputAndResult(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("//;\\n5;6;7;2", 3),
                Arguments.of("//+(\\n2,3:6+7", 2),
                Arguments.of("//#\\n2#4#7", 3),
                Arguments.of("//,\\n3,4,5,10", 2)
            )
        }
    }
}