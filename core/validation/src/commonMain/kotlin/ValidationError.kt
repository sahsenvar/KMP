import markers.response.KmpError

sealed interface ValidationError : KmpError {
    data class IdentifierDoesNotDetermined(override val message: String): ValidationError

}