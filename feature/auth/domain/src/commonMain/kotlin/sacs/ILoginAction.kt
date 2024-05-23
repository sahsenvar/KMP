package sacs

import IdentifierType
import markers.sanc.Action

interface ILoginAction: Action {

    // Navigation
    fun goToHomeScreen()

    fun goToRegisterScreen()

    fun goToTermsScreen()

    fun goToForgottenPasswordScreen()

    // Business Process
    fun loginWithCredential(identifier: String, password: String, hasTermsApproved: Boolean)

    fun determineIdentifierType(identifier: String): IdentifierType


}