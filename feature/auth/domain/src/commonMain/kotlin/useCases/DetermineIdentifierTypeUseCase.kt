package useCases

import IdentifierType
import ValidationError
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import markers.cleanArch.useCase.AsyncUseCase
import markers.cleanArch.useCase.SyncUseCase
import markers.response.KmpResponse
import repositories.LoginRepository
import kotlin.coroutines.CoroutineContext

class DetermineIdentifierTypeUseCase(
    private val repository: LoginRepository,
    dispatcher: CoroutineContext
) : AsyncUseCase(dispatcher) {

    operator fun invoke(
        identifier: String,
        onEach: suspend KmpResponse<IdentifierType, ValidationError>.() -> Unit
    ) = runUseCase { repository.determineIdentifierType(identifier) }
        .filterNot { it is KmpResponse.Loading }
        .onEach(onEach)
        .launchIn(MainScope())

}