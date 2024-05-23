package com.sahansenvar.kmp

import PlatformApp
import android.app.Application

class KMPAndroidApp(): Application() {
    override fun onCreate() {
        super.onCreate()
        Injector.initInjector(PlatformApp(this))
    }
}