class EmailValidation : IdentifierValidation {
    override fun validatePattern(input: String): Boolean {
        return input
            .trim()
            .matches(EMAIL_PATTERN)
    }

    companion object {
        private val EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$".toRegex()
    }
}