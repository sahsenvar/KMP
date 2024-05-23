package com.sahansenvar.kmp.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.http.DEFAULT_PORT
import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import io.ktor.http.parameters
import io.ktor.http.parametersOf
import io.ktor.http.path
import io.ktor.util.toLowerCasePreservingASCIIRules
import markers.models.DataModel
import markers.models.RequestModel
import markers.response.BaseResponse
import markers.response.KmpResponse
import markers.response.NetworkError

class HttpService(
    private val protocol: URLProtocol,
    private val host: String
) {

    suspend fun <DATA : DataModel> get(
        protocol: URLProtocol = this.protocol,
        host: String = this.host,
        path: String,
        body: RequestModel? = null,
        vararg query: Pair<String, List<String>> = arrayOf()
    ): KmpResponse<BaseResponse<DATA>, NetworkError> {
        val request = client.request {
            method = HttpMethod.Get
            url.protocol = protocol
            url.host = host
            url.path(path)
            parametersOf(*query)
            setBody(body)
        }
        return request.body()
    }

    companion object {
        private val client: HttpClient = HttpClient()

    }
}
