import org.gradle.api.Project
import java.lang.Exception

fun getNameSpace(project: Project): String {
    project.parent ?: throw Exception("Use project! Not root project")
    val modulePath = project.path.replace(':', '.')
    return Config.PACKAGE_NAME + modulePath
}