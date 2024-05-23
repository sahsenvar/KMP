import com.arkivanov.decompose.ComponentContext

sealed interface ChildScreen{
    data class SplashScreen(val component: ComponentContext) : ChildScreen
    data class LoginScreen(val component: ComponentContext) : ChildScreen
    data class RegisterScreen(val component: ComponentContext) : ChildScreen
    data class HomeScreen(val component: ComponentContext) : ChildScreen
}