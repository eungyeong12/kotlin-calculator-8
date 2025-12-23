package calculator.view

object OutputView {
    private const val INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요."
    private const val RESULT_PROMPT = "결과 :"

    fun displayInputPrompt() {
        println(INPUT_PROMPT)
    }

    fun displayResult(result: Int) {
        println("$RESULT_PROMPT $result")
    }
}