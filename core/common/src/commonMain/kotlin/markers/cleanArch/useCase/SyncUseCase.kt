package markers.cleanArch.useCase

import markers.response.KmpError
import markers.response.KmpResponse
import kotlin.coroutines.CoroutineContext

abstract class SyncUseCase(
    private val dispatcher: CoroutineContext
): UseCase {

}