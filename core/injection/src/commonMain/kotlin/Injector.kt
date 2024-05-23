import di.authDataLayerModule
import di.authDomainLayerModule
import di.authPresentationLayerModule
import di.homeDataLayerModule
import di.homeDomainLayerModule
import di.homePresentationLayerModule
import di.splashDataLayerModule
import di.splashDomainLayerModule
import di.splashPresentationLayerModule
import di.validationModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.plus
import org.koin.dsl.module

object Injector {
    lateinit var koinApplication: KoinApplication

    inline fun <reified T : Any> get(): T {
        return koinApplication.koin.get()
    }

    fun initInjector(app: PlatformApp) {
        koinApplication = startKoin {
            modules(
                listOf(module { single { app } })
                    .plus(commonCoreModule)
                    .plus(commonFeatureModule)
            )
        }
    }
}