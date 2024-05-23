import com.arkivanov.decompose.ComponentContext

fun screenToChildFactory(screen: Screen, context: ComponentContext) = when(screen){
    Screen.SplashScreen -> ChildScreen.SplashScreen(context)
    Screen.HomeScreen -> ChildScreen.HomeScreen(context)
    Screen.LoginScreen -> ChildScreen.LoginScreen(context)
    Screen.RegisterScreen -> ChildScreen.RegisterScreen(context)
}