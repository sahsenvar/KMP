package di

import ValidationService
import com.sahansenvar.kmp.remote.HttpService
import com.sahansenvar.kmp.remote.Protocol
import dataSources.LoginRemoteSource
import dataSources.LoginLocalSource
import dataSources.LoginMemorySource
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import repositories.LoginRepositoryImpl

val authDataLayerModule = module {
    factory {
        HttpService(
            host = "www.google.com", //todo: Fake bir backend oluştur
            protocol = Protocol.HTTPS
        )
    }

    factoryOf(::LoginRemoteSource)
    factoryOf(::LoginLocalSource)
    factoryOf(::LoginMemorySource)
    factoryOf(::LoginRepositoryImpl)
}