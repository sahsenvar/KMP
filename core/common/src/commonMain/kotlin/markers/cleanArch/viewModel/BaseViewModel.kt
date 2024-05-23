package markers.cleanArch.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import markers.sanc.UiState

interface ModelState<STATE> {
    val state: Flow<STATE>
}
abstract class BaseViewModel<STATE: UiState>(
    private val model: STATE
): ViewModel() {
    protected val _state: MutableStateFlow<STATE> = MutableStateFlow(model)
    val state: StateFlow<STATE>
        get() = _state.asStateFlow()
}