@file:Suppress("UnstableApiUsage")

rootProject.name = "KMP"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}



// <========================| Core Modules |========================>
include(
    ":core:common",
    ":core:navigation",
    ":core:remote",
    ":core:local",
    ":core:memory",
    ":core:validation",
    ":core:injection",
)

// <========================| Compose Application Modules |========================>
include(
    ":composeApp",
)

// <========================| Splash Modules |========================>
include(
    ":feature:splash:data",
    ":feature:splash:domain",
    ":feature:splash:presentation",
)

// <========================| Auth Modules |========================>
include(
    ":feature:auth:data",
    ":feature:auth:domain",
    ":feature:auth:presentation",
)

// <========================| Home Modules |========================>
include(
    ":feature:home:data",
    ":feature:home:domain",
    ":feature:home:presentation",
)