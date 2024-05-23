package com.sahansenvar.kmp.remote

import io.ktor.http.DEFAULT_PORT
import io.ktor.http.URLProtocol
import io.ktor.util.toLowerCasePreservingASCIIRules

object Protocol {
    /**
     * HTTP with port 80
     */
    val HTTP = URLProtocol("http", 80)

    /**
     * secure HTTPS with port 443
     */
    val HTTPS = URLProtocol("https", 443)

    /**
     * Web socket over HTTP on port 80
     */
    val WS = URLProtocol("ws", 80)

    /**
     * Web socket over secure HTTPS on port 443
     */
    val WSS = URLProtocol("wss", 443)

    /**
     * Socks proxy url protocol.
     */
    val SOCKS = URLProtocol("socks", 1080)

    /**
     * Protocols by names map
     */
    val byName: Map<String, io.ktor.http.URLProtocol> =
        listOf(HTTP, HTTPS, WS, WSS, SOCKS).associateBy { it.name }

    /**
     * Create an instance by [name] or use already existing instance
     */
    fun createOrDefault(name: String): io.ktor.http.URLProtocol =
        name.toLowerCasePreservingASCIIRules().let {
            byName[it] ?: URLProtocol(it, DEFAULT_PORT)
        }
}