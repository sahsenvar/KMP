package markers.response

interface KmpError{
    val message: String
    data class UnknownError(override val message: String): KmpError
}
