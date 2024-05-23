package di

import extentions.viewModel
import org.koin.dsl.module
import viewModels.LoginViewModel

val authPresentationLayerModule = module {
    viewModel { LoginViewModel(get(), get(), get(), get(), get()) }
}