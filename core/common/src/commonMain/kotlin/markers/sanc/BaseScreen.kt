package markers.sanc

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow
import markers.cleanArch.viewModel.BaseViewModel

abstract class BaseScreen(
    componentContext: ComponentContext
){

    protected lateinit var state: State<*>
    @Composable
    abstract fun render()
}