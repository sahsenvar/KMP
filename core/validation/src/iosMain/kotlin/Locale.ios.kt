import platform.Foundation.NSLocale
import platform.Foundation.countryCode
import platform.Foundation.currentLocale

actual val locale: String?
    get() = NSLocale.currentLocale.countryCode