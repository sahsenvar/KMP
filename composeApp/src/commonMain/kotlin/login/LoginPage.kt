package login

import IdentifierType
import actions.LoginAction
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import states.LoginState

@Composable
fun LoginPage(state: LoginState, action: LoginAction) {
    IdentityTextField(
        modifier = Modifier,
        value = ,
        identifierType = state.identifierType,
        determinateIcon =
        )
}

@Composable
fun IdentityTextField(
    modifier: Modifier
    value: String,
    identifierType: IdentifierType,
    determinateIcon: (String) -> Unit
) {
    var text by remember { mutableStateOf(value) }
    NormalTextField(
        value = text,
        onValueChange = determinateIcon,
        leadingIcon = {
            when (identifierType) {
                IdentifierType.Email -> Icons.Outlined.Email
                IdentifierType.Phone -> Icons.Outlined.Phone
                IdentifierType.Unknown -> null
            }?.let { Icon(imageVector = it, contentDescription = null) }
        },
        trailingIcon = {
            CircularProgressIndicator()
        }
    )
}


@Composable
fun NormalTextField(
    value: String,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onValueChange: (value: String) -> Unit
) {
    var text by remember { mutableStateOf(value) }
    OutlinedTextField(
        value = text,
        onValueChange = { newText ->
            text = newText
            onValueChange(newText)
        },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
    )
}