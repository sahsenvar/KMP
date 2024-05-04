package com.sahansenvar.kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform