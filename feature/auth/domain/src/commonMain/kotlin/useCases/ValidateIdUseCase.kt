package useCases

import repositories.LoginRepository

class ValidateIdUseCase(
    private val loginRepository: LoginRepository
) {
}