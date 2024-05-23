package markers.cleanArch.useCase

import markers.response.KmpResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import markers.response.KmpError
import kotlin.coroutines.CoroutineContext

abstract class AsyncUseCase(
    private val dispatcher: CoroutineContext
) : UseCase {
    protected fun <DATA, ERROR: KmpError> runUseCase(body: suspend () -> KmpResponse<DATA, ERROR>) = flow {
        emit(KmpResponse.Loading)
        when (val response: KmpResponse<DATA, ERROR> = body.invoke()) {
            is KmpResponse.Success -> emit(KmpResponse.Success(response.data))
            is KmpResponse.Failure -> emit(KmpResponse.Failure(response.cause))
            else -> Unit
        }
    }.catch {
        //emit(KmpResponse.Failure(KmpError.UnknownError(it)))
    }.flowOn(dispatcher)
}