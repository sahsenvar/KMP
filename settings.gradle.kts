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

include(":androidApp")
include(":shared")
include(
    ":core:remote",
    ":core:local"
)

include(
    ":feature:auth:data",
    ":feature:auth:domain",
    ":feature:auth:presentation",
)
include(
    ":feature:home:data",
    ":feature:home:domain",
    ":feature:home:presentation",
)
include(
    ":feature:splash:data",
    ":feature:splash:domain",
    ":feature:splash:presentation",
)
