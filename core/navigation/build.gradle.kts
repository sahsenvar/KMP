apply(from = rootProject.file("base.gradle"))
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
    id("kotlin-parcelize")
}

kotlin {
    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        group = getNameSpace(project)
        ios.deploymentTarget = "16.0"
        podfile = rootProject.file("iosApp/Podfile")
        framework {
            baseName = "navigation"
            isStatic = true

            export(libs.navigation.lifecycle)
            export(libs.navigation.stateKeeper)
            export(libs.navigation.parcelize)
        }
    }

    sourceSets {
        androidMain.dependencies{
            api(libs.navigation.extention)
        }
        commonMain.dependencies {
            implementation(libs.kotlin.serialization)
            api(libs.navigation.core)
            api(libs.navigation.extention)
        }
        commonTest.dependencies {
            implementation(projects.core.common)
        }

        iosMain.dependencies {
            api(libs.navigation.lifecycle)
            api(libs.navigation.parcelize)
            api(libs.navigation.stateKeeper)
        }
    }
}

android.namespace = getNameSpace(project)