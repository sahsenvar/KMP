package viewModels

import ComponentState
import IdentifierType
import ValidationError
import androidx.compose.ui.window.Popup
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import markers.cleanArch.viewModel.BaseViewModel
import markers.response.KmpError
import markers.response.KmpResponse
import markers.response.componentState
import markers.response.data
import markers.response.onFailure
import markers.response.onSuccess
import states.LoginState
import useCases.DetermineIdentifierTypeUseCase
import useCases.GetBackgroundImageUseCase
import useCases.LoginWithCredentialUseCase
import useCases.ValidateIdUseCase
import useCases.ValidatePasswordUseCase

class LoginViewModel(
    private val getBackgroundImage: GetBackgroundImageUseCase,
    private val loginWithCredential: LoginWithCredentialUseCase,
    private val determineIdentifierType: DetermineIdentifierTypeUseCase,
    private val validateIdentifier: ValidateIdUseCase,
    private val validatePassword: ValidatePasswordUseCase
) : BaseViewModel<LoginState>(LoginState()) {

    fun loginWithCredential(
        identifier: String,
        password: String,
    ) = viewModelScope.launch {
        //todo: validateIdentifier(identifier, identifierType)
        //todo: validatePassword(password)
        //todo: loginWithCredentials(identifier, password, identifierType)
    }

    fun getIdentifierType(identifier: String) = determineIdentifierType.invoke(identifier) {
        _state.value = state.value.copy(
            identifierTextFieldState = this.componentState,
            identifierType = data ?: IdentifierType.Unknown
        )
    }

}