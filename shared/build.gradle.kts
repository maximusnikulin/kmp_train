import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    //TODO: place to libs
    id("io.github.timortel.kmpgrpc.plugin") version "1.5.0"
}

kotlin {
    applyDefaultHierarchyTemplate()
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            // TODO: add automaticaly check for build in debug
            isStatic = false
            binaryOption("bundleId", "com.somesome.Shared")
        }
    }

    sourceSets {
        commonMain.dependencies {
            // put your Multiplatform dependencies here
            implementation(libs.kotlinx.coroutines.core)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

kmpGrpc {
    // declare the targets you need.
    common() // required
    jvm()
    android()
    js()
    native()  // for native targets like iOS

    // Optional: if the protobuf well known types should be included
    // https://protobuf.dev/reference/protobuf/google.protobuf/
    includeWellKnownTypes = true

    // Optional: if all generated source files should have 'internal' visibility.
    internalVisibility = true

    // Specify the folders where your proto files are located, you can list multiple.
    protoSourceFolders = project.files("../protos")
}

android {
    namespace = "com.example.kmp_train.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
