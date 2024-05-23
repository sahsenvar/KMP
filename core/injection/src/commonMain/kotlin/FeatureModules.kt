import dataSources.LoginLocalSource
import dataSources.LoginMemorySource
import dataSources.LoginRemoteSource
import extentions.viewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import repositories.LoginRepository
import repositories.LoginRepositoryImpl
import useCases.DetermineIdentifierTypeUseCase
import useCases.LoginWithCredentialUseCase
import viewModels.LoginViewModel

val splashModule = module {

}
val authModule = module {
    // Data
    factory { LoginRemoteSource(get(named("AppClient"))) }
    factoryOf(::LoginLocalSource)
    factoryOf(::LoginMemorySource)
    factory<LoginRepository>{LoginRepositoryImpl(get(),get(),get(),get())}

    // Domain
    factoryOf(::DetermineIdentifierTypeUseCase)
    factoryOf(::LoginWithCredentialUseCase)

    //Presentation
    viewModel { LoginViewModel(get(), get(), get(), get(), get()) }
}
val homeModule = module {

}

val commonFeatureModule: List<Module> = listOf(
    splashModule,
    authModule,
    homeModule
)


