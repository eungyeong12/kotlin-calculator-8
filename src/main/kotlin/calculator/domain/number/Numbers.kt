package calculator.domain.number

import calculator.exception.ExceptionMessage
import calculator.exception.ValidationException
import java.math.BigInteger

class Numbers private constructor(
    private val numbers: List<BigInteger>
) {
    fun getNumbers(): List<BigInteger> {
        return numbers
    }

    companion object {
        fun from(tokens: List<String>): Numbers {
            return Numbers(parseNumbers(tokens))
        }

        private fun parseNumbers(tokens: List<String>): List<BigInteger> {
            return tokens.map {
                val n = try {
                    BigInteger(it)
                } catch (_: Exception) {
                    throw ValidationException(ExceptionMessage.INVALID_NON_DELIMITER_CHARACTER)
                }

                if (n < BigInteger.ZERO) {
                    throw ValidationException(ExceptionMessage.INVALID_NON_DELIMITER_CHARACTER)
                }
                n
            }
        }
    }
}