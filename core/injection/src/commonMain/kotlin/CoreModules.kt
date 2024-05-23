import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val commonModule = module {

}
val remoteModule = module {

}
val localModule = module {

}
val memoryModule = module {

}
val validationModule = module {
    factoryOf(::ValidationService)
}

val commonCoreModule: List<Module> = listOf(
    commonModule,
    remoteModule,
    localModule,
    memoryModule,
    validationModule
)