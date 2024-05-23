package login

import BaseScreenV2
import actions.LoginAction
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import com.arkivanov.decompose.ComponentContext
import states.LoginState
import viewModels.LoginPage
import viewModels.LoginViewModel

class LoginScreen(
    component: ComponentContext
) {

    @Composable
    operator fun invoke() {
        LoginPage()
    }
}