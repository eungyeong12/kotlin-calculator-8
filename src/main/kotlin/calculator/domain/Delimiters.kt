package calculator.domain

@JvmInline
value class Delimiters(
    val value: List<String>
) {

    companion object {
        fun from(input: String): Delimiters {
            val regex = Regex("""^//(.)\\n""")
            if (regex.containsMatchIn(input)) {
                val match = regex.find(input)
                return Delimiters(listOf(",", ":", match?.groupValues[1].toString()))
            }
            return Delimiters(listOf(",", ":"))
        }
    }
}