apply(from = rootProject.file("base.gradle"))
apply(from = rootProject.file("base-data.gradle"))
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    cocoapods {
        name = "authData"
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        group = getNameSpace(project = project)
        ios.deploymentTarget = "16.0"
        podfile = rootProject.file("iosApp/Podfile")
        framework {
            baseName = "authData"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":core:remote"))
            implementation(project(":core:local"))
            implementation(project(":core:memory"))
            implementation(project(":core:validation"))

            implementation(project(":feature:auth:domain"))
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android.namespace = getNameSpace(project = project)
dependencies {
    implementation(project(":core:memory"))
}
