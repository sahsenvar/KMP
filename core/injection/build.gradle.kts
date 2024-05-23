apply(from = rootProject.file("base.gradle"))
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
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
            baseName = "injection"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies{
            implementation("io.insert-koin:koin-android:3.5.6")
        }
        commonMain.dependencies {
            implementation("io.insert-koin:koin-core:3.5.6")

            // Modules
            implementation(projects.core.common)
            implementation(projects.core.remote)
            implementation(projects.core.local)
            implementation(projects.core.memory)
            implementation(projects.core.navigation)
            implementation(projects.core.validation)

            // Features
            implementation(projects.feature.splash.data)
            implementation(projects.feature.splash.domain)
            implementation(projects.feature.splash.presentation)

            implementation(projects.feature.auth.data)
            implementation(projects.feature.auth.domain)
            implementation(projects.feature.auth.presentation)
            
            implementation(projects.feature.home.data)
            implementation(projects.feature.home.domain)
            implementation(projects.feature.home.presentation)

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation("io.insert-koin:koin-test:3.5.6")
        }
    }
}

android.namespace = getNameSpace(project = project)