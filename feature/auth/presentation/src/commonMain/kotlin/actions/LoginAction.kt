package actions

import IdentifierType
import sacs.ILoginNavigator
import sacs.ILoginAction
import viewModels.LoginViewModel

class LoginAction(
    private val viewModel: LoginViewModel,
    private val navigator: ILoginNavigator
) : ILoginAction {
    override fun goToHomeScreen() {
        navigator.toHomeScreen()
    }

    override fun goToRegisterScreen() {
        navigator.toRegisterScreen()
    }

    override fun goToTermsScreen() {
        navigator.toTermsScreen()
    }

    override fun goToForgottenPasswordScreen() {
        navigator.toForgottenPasswordScreen()
    }

    override fun loginWithCredential(
        identifier: String,
        password: String,
        hasTermsApproved: Boolean
    ) {
        viewModel.loginWithCredential(
            identifier = identifier,
            password = password,
            hasTermsApproved = hasTermsApproved
        )
    }

    override fun determineIdentifierType(identifier: String): IdentifierType {
        TODO("Not yet implemented")
    }


}