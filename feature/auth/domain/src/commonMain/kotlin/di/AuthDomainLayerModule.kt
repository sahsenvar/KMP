package di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import useCases.DetermineIdentifierTypeUseCase
import useCases.LoginWithCredentialUseCase

val authDomainLayerModule = module {
    factoryOf(::LoginWithCredentialUseCase)
    factoryOf(::DetermineIdentifierTypeUseCase)
}