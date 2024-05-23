package screen

import actions.LoginAction
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.arkivanov.decompose.ComponentContext
import markers.cleanArch.viewModel.BaseViewModel
import markers.sanc.BaseScreen
import states.LoginState
import viewModels.LoginPage

class LoginScreen(
    componentContext: ComponentContext
) : BaseScreen(componentContext) {
    private lateinit var viewModel: BaseViewModel<LoginState>
    private lateinit var action: LoginAction
    @Composable
    override fun render() {
        val loginState by viewModel.state.collectAsState(LoginState())
        LoginPage(loginState, action)
    }

}