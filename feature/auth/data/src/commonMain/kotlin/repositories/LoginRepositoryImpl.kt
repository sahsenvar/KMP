package repositories

import ValidationService
import dataSources.LoginLocalSource
import dataSources.LoginMemorySource
import dataSources.LoginRemoteSource

class LoginRepositoryImpl(
    private val loginRemoteSource: LoginRemoteSource,
    private val loginLocalSource: LoginLocalSource,
    private val loginMemorySource: LoginMemorySource,
    private val validationService: ValidationService
) : LoginRepository{

}