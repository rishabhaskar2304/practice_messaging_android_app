plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.protobuf") version("0.9.1")
}

//protobuf {
//    protoc {
//        artifact = "com.google.protobuf:protoc:3.25.3"
//    }
//    plugins {
//        id("kotlin") {
//            artifact = "io.grpc:protoc-gen-kotlin:1.67.1"
//        }
//    }
//    generateProtoTasks {
//        all().forEach { task ->
//            task.plugins {
//                id("kotlin") {
//                    option("lite")
//                }
//            }
//        }
//    }
//}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.21.12"
    }
    plugins {
        create("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.52.1"
        }
        create("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:1.3.0:jdk8@jar"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                create("grpc")
                create("grpckt")
            }
            it.builtins {
                create("java") //needed either it throws Unresolved Reference
                create("kotlin")
            }
        }
    }

}


android {
    namespace = "com.bms.mobile.application"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.bms.mobile.application"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

//    implementation(libs.grpc.grpc.okhttp)
//    implementation(libs.grpc.grpc.stub)
//    implementation("com.google.protobuf:protobuf-javalite:3.25.3")
//    implementation("com.google.protobuf:protobuf-kotlin-lite:3.25.3")
//    compileOnly(libs.annotations.api) // necessary for Java 9+
    implementation("io.grpc:grpc-stub:1.52.1")
    implementation("io.grpc:grpc-protobuf:1.52.1")
    implementation("io.grpc:grpc-okhttp:1.52.1")
    implementation("io.grpc:protoc-gen-grpc-kotlin:1.3.0")
    implementation("io.grpc:grpc-kotlin-stub:1.3.0")
    implementation("com.google.protobuf:protobuf-kotlin:3.21.12")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}