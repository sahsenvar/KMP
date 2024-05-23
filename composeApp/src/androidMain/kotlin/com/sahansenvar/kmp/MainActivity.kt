package com.sahansenvar.kmp

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.decompose.handleDeepLink
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import viewModels.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val deeplink = intent.data
        setContent {
            val rootComponent = defaultComponentContext()
            App(rootComponent, deeplink)
        }
    }
}