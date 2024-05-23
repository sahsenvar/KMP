package states

import ComponentState
import IdentifierType
import markers.sanc.UiState

data class LoginState(
    val loginButtonState: ComponentState = ComponentState.Idle,
    val identifierType: IdentifierType = IdentifierType.Unknown,
    val identifierTextFieldState: ComponentState = ComponentState.Idle
): UiState