apply(from = rootProject.file("base.gradle"))
apply(from = rootProject.file("base-presentation.gradle"))
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    cocoapods {
        name = "homePresentation"
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        group = getNameSpace(project = project)
        ios.deploymentTarget = "16.0"
        podfile = rootProject.file("iosApp/Podfile")
        framework {
            baseName = "homePresentation"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android.namespace = getNameSpace(project = project)