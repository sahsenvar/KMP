package useCases

import repositories.LoginRepository

class LoginWithCredentialUseCase(
    private val loginRepository: LoginRepository
) {
}