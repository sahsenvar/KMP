package markers.response

sealed interface KmpResponse<out DATA, out CAUSE : KmpError> {
    data class Success<out DATA>(val data: DATA) : KmpResponse<DATA, Nothing>
    data class Failure<CAUSE : KmpError>(val cause: CAUSE) : KmpResponse<Nothing, CAUSE>
    data object Loading : KmpResponse<Nothing, Nothing>
}

// Extension Properties
val <DATA, CAUSE: KmpError> KmpResponse<DATA, CAUSE>.data
    get() = if (this is KmpResponse.Success) this.data else null

val <DATA ,CAUSE : KmpError> KmpResponse<DATA, CAUSE>.cause
    get() = if (this is KmpResponse.Failure) this.cause else null

val <DATA, CAUSE : KmpError> KmpResponse<DATA, CAUSE>.isSuccess
    get() = if (this is KmpResponse.Success) true else false

val <DATA, CAUSE : KmpError> KmpResponse<DATA, CAUSE>.isFailure
    get() = if (this is KmpResponse.Failure) true else false

val <DATA, CAUSE : KmpError> KmpResponse<DATA, CAUSE>.componentState
    get() = when(this){
        is KmpResponse.Failure -> ComponentState.Failure(this.cause.message)
        is KmpResponse.Loading -> ComponentState.Loading()
        is KmpResponse.Success -> ComponentState.Success()
    }

// Extension Functions
fun <DATA, CAUSE : KmpError> KmpResponse<DATA, CAUSE>.onSuccess(block: (data: DATA) -> Unit): KmpResponse<DATA, CAUSE> {
    if (this is KmpResponse.Success) block.invoke(this.data)
    return this
}

fun<DATA, CAUSE : KmpError> KmpResponse<DATA, CAUSE>.onFailure(block: (reason: CAUSE) -> Unit): KmpResponse<DATA, CAUSE> {
    if (this is KmpResponse.Failure)
        block.invoke(this.cause)
    return this
}