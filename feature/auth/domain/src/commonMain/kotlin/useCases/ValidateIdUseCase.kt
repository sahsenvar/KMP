package useCases

import markers.cleanArch.useCase.SyncUseCase
import repositories.LoginRepository

class ValidateIdUseCase(
    private val loginRepository: LoginRepository
) : SyncUseCase() {
    operator fun invoke(userIdentity: String) = runCatching{
        null
    }
}