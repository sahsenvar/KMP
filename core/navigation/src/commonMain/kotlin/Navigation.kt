import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.value.Value

interface Navigation{
    val navigation: StackNavigation<Screen>

    val stack: Value<ChildStack<*, ChildScreen>>
}