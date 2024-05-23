import android.net.Uri
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.stack.Children
import markers.sanc.BaseScreen
import org.koin.java.KoinJavaComponent.inject
import viewModels.LoginViewModel

class App(
    componentContext: ComponentContext,
    deeplink: Uri?
): BaseScreen(componentContext){

    val viewModel: LoginViewModel by inject(::LoginViewModel.javaClass)

    @Composable
    override fun render() {

    }


}