package repositories

import IdentifierType
import ValidationError
import markers.response.KmpResponse
import markers.response.NetworkError

interface LoginRepository {

    suspend fun loginWithCredential(identifier: String, password: String)//: KmpResponse<Unit, NetworkError>

    fun determineIdentifierType(identifier: String): KmpResponse<IdentifierType, ValidationError>

}