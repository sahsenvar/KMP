package di

import ValidationService
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val validationModule = module {
     factoryOf(::ValidationService)
}