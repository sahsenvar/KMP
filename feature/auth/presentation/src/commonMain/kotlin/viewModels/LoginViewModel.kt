package viewModels

import useCases.GetBackgroundImageUseCase
import useCases.TryLoginUseCase
import useCases.ValidateIdUseCase
import useCases.ValidatePasswordUseCase

class LoginViewModel(
    private val getBackgroundImageUseCase: GetBackgroundImageUseCase,
    private val tryLoginUseCase: TryLoginUseCase,
    private val validateIdUseCase: ValidateIdUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase
){

}