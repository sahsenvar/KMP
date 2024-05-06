package useCases

import repositories.LoginRepository

class GetBackgroundImageUseCase(
    private val loginRepository: LoginRepository
) {
}