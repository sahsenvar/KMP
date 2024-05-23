apply(from = rootProject.file("base.gradle"))
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    id("kotlin-parcelize")
    alias(libs.plugins.composePlugin)
}

kotlin {
    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        group = getNameSpace(project = project)
        ios.deploymentTarget = "16.0"
        podfile = rootProject.file("iosApp/Podfile")
        framework {
            baseName = "common"
            isStatic = true
        }
    }

    sourceSets {

        androidMain.dependencies {

        }
        commonMain.dependencies {

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            implementation("androidx.lifecycle:lifecycle-viewmodel:2.8.0-rc01")

            implementation(libs.navigation.core)
            implementation(libs.navigation.lifecycle)
            implementation(libs.navigation.extention)
            implementation(libs.navigation.stateKeeper)
            implementation(libs.navigation.parcelize)
        }

        commonTest.dependencies {

        }
    }
}

android.namespace = getNameSpace(project)
