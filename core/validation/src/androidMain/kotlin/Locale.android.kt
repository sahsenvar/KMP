import java.util.Locale

actual val locale: String?
    get() = Locale.getAvailableLocales().first().country