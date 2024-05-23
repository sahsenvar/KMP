package dataSources

import com.sahansenvar.kmp.remote.HttpService
import models.UserCredential

class LoginRemoteSource(
    private val httpService: HttpService
) {
    suspend fun loginWithCredential(identifier: String, password: String) {
        httpService.get<Nothing>(
            path = ENDPOINT_LOGIN_WITH_CREDENTIALS,
            body = UserCredential(identifier, password, true)
        )
    }

    companion object{
        const val ENDPOINT_LOGIN_WITH_CREDENTIALS = "auth/loginWithCredentials"
    }
}