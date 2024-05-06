package useCases

import repositories.LoginRepository

class ValidatePasswordUseCase(
    private val loginRepository: LoginRepository
) {
}