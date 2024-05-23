apply(from = rootProject.file("base.gradle"))
apply(from = rootProject.file("base-presentation.gradle"))
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composePlugin)
    alias(libs.plugins.kotlinSerialization)

}

kotlin {
    cocoapods {
        name = "authPresentation"
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        group = getNameSpace(project = project)
        ios.deploymentTarget = "16.0"
        podfile = rootProject.file("iosApp/Podfile")
        framework {
            baseName = "authPresentation"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //Modules
            implementation(projects.feature.auth.domain)
            implementation(projects.core.navigation)
            implementation(projects.core.validation)

            //Libraries
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.kotlin.serialization)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        androidMain.dependencies {
            implementation("androidx.compose.runtime:runtime:1.6.7")
        }
    }
}

android.namespace = getNameSpace(project = project)