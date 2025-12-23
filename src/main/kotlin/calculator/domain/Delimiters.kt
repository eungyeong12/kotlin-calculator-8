package calculator.domain

class Delimiters private constructor(
    val delimiters: Set<Char>
) {
    fun toCharArray(): CharArray {
        return delimiters.toCharArray()
    }

    companion object {
        private val DEFAULT_DELIMITERS: Set<Char> = setOf(',', ':')

        fun from(input: String): Delimiters {
            val customDelimiter = CustomDelimiter.from(input)
            if (customDelimiter.value != null) {
                return Delimiters(DEFAULT_DELIMITERS + customDelimiter.value)
            }
            return Delimiters(DEFAULT_DELIMITERS)
        }
    }
}