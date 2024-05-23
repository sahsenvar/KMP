package navigation

import Screen
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.push
import sacs.ILoginNavigator

class LoginNavigator(
    private val navigation: StackNavigation<Screen>
): ILoginNavigator {
    override fun toHomeScreen() {
        navigation.push(Screen.HomeScreen)
    }

    override fun toRegisterScreen() {
        navigation.push(Screen.RegisterScreen)
    }

    override fun toTermsScreen() {
        navigation.push(Screen.RegisterScreen)
    }

    override fun toForgottenPasswordScreen() {
        navigation.push(Screen.RegisterScreen)
    }

}