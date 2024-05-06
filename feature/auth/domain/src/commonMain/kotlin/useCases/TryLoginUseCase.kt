package useCases

import repositories.LoginRepository

class TryLoginUseCase(
    private val loginRepository: LoginRepository
) {
}