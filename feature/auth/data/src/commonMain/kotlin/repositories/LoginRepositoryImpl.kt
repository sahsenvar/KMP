package repositories

import IdentifierType
import ValidationError
import ValidationService
import dataSources.LoginLocalSource
import dataSources.LoginMemorySource
import dataSources.LoginRemoteSource
import markers.response.KmpResponse
import markers.response.NetworkError

class LoginRepositoryImpl(
    private val loginRemoteSource: LoginRemoteSource,
    private val loginLocalSource: LoginLocalSource,
    private val loginMemorySource: LoginMemorySource,
    private val validationService: ValidationService
) : LoginRepository{
    override suspend fun loginWithCredential(identifier: String, password: String)/*: KmpResponse<Unit, NetworkError>*/ {
        return loginRemoteSource.loginWithCredential(identifier, password)
    }

    override fun determineIdentifierType(identifier: String): KmpResponse<IdentifierType, ValidationError> {
        return validationService.determineIdentifierType(identifier)
    }
}