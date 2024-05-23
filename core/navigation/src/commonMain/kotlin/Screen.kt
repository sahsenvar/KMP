import com.arkivanov.decompose.router.stack.ChildStack
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable data object SplashScreen : Screen()
    @Serializable data object LoginScreen : Screen()
    @Serializable data object RegisterScreen: Screen()
    @Serializable data object HomeScreen : Screen()
}