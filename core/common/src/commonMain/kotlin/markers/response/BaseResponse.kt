package markers.response

data class BaseResponse<DATA>(
    val result: String,
    val response: DATA
)
