package viewModels

import ComponentState
import actions.LoginAction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxColors
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import states.LoginState


@Composable
fun LoginPage(state: LoginState, action: LoginAction) {
    var identifier: String = remember { "" }
    var password: String = remember { "" }
    var hasTermsApproved = remember { false }
    Column(modifier = Modifier.fillMaxSize()) {


        LoginButton(
            modifier = Modifier.width(200.dp),
            text = "login",
            state = state.loginButtonState,
            onClick = { action.loginWithCredential(identifier, password, hasTermsApproved) }
        )
    }
}

@Composable
fun MandatoryCheckText(
    onCheckedChange: (Boolean) -> Unit,
    textContent: @Composable RowScope.(checked: Boolean) -> Unit
) {
    var checked: Boolean = remember { false }
    var firstTime = true
    CheckText(
        checked = checked,
        onCheckedChange = { hasChecked ->
            firstTime = false
            checked = hasChecked
        },
        colors = if(firstTime) CheckboxDefaults.colors() else CheckboxDefaults.colors(uncheckedColor = Color.Red),
        textContent = textContent
    )
}

@Composable
fun CheckText(
    checkBoxModifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    colors: CheckboxColors = CheckboxDefaults.colors(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    textContent: @Composable RowScope.(checked: Boolean) -> Unit
) {
    Row {
        Checkbox(
            checked = checked,
            modifier = checkBoxModifier,
            onCheckedChange = onCheckedChange,
            colors = colors,
            interactionSource = interactionSource
        )
        textContent(checked)
    }
}


@Composable
fun LoginButton(
    modifier: Modifier = Modifier,
    text: String = "Click me",
    state: ComponentState,
    onClick: () -> Unit,
    onState: @Composable ((state: ComponentState) -> Unit)? = null
) = StatefulButton(
    modifier = modifier,
    text = text,
    state = state,
    onClick = onClick,
    onState = onState
)

@Composable
fun StatefulButton(
    modifier: Modifier = Modifier,
    text: String,
    state: ComponentState,
    onClick: () -> Unit,
    onState: @Composable ((state: ComponentState) -> Unit)? = null
) = Button(
    modifier = modifier,
    onClick = onClick,
    enabled = state !is ComponentState.Loading
) {
    onState?.invoke(state) ?: when (state) {
        is ComponentState.Idle -> AtomText(text = text, color = Color.White)
        is ComponentState.Loading -> AtomText(text = "Loading", color = Color.White)
        is ComponentState.Success -> AtomText(text = "Success", color = Color.White)
        is ComponentState.Failure -> AtomText(text = "Failure", color = Color.White)
    }
}


@Composable
fun AtomText(
    modifier: Modifier = Modifier,
    text: String?,
    color: Color = Color.Blue,
    size: TextUnit = 16.sp
) {
    if (!text.isNullOrEmpty()) {
        Text(
            text = text,
            style = TextStyle(fontFamily = FontFamily.SansSerif),
            color = color,
            fontSize = size,
            modifier = Modifier
                .padding(PaddingValues(end = 8.dp))
                .then(modifier)
        )
    }
}