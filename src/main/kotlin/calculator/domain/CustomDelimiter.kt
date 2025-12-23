package calculator.domain

@JvmInline
value class CustomDelimiter private constructor(
    val value: Char?
) {
    companion object {
        fun from(input: String): CustomDelimiter {
            val value = extractCustomDelimiter(input)
            return CustomDelimiter(value)
        }

        private fun extractCustomDelimiter(input: String): Char? {
            val regex = Regex("""^//(.)\\n""")
            val matchResult = regex.find(input)
            if (matchResult != null) {
                return matchResult.groupValues[1].first()
            }
            return null
        }
    }
}