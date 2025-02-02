pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral() // Replaces JCenter with Maven Central for broader dependency support
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") } // Include JitPack for your dependencies
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google() // Google's repository for Android libraries
        mavenCentral() // Maven Central as the primary repository
        gradlePluginPortal()

        maven { url = uri("https://jitpack.io") } // JitPack for GitHub-hosted dependencies
    }
}

rootProject.name = "javabook"
include(":app")
