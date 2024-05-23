apply(from = rootProject.file("base.gradle"))
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.skie)

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
            baseName = "remote"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.coroutines.core)
            implementation("io.ktor:ktor-client-core:2.3.10")
            implementation(projects.core.common)
        }
        commonTest.dependencies {

        }
    }
}


android.namespace = getNameSpace(project = project)