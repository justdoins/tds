val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project
val slf4jVersion:String by project
val mongodbVersion:String by project
val coroutinesVersion:String by project
plugins {
    kotlin("jvm") version "1.9.21"
    id("io.ktor.plugin") version "2.3.7"
}

group = "org.dustbins"
version = "0.0.1-SNAPSHOT"

repositories {
    maven("https://maven.aliyun.com/repository/public/")
    maven("https://maven.aliyun.com/repository/central")
    maven("https://maven.aliyun.com/repository/gradle-plugin")
    maven("https://maven.aliyun.com/repository/apache-snapshots")
    mavenCentral()
}
application {
    mainClass.set("org.dustbin.MainKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}


object VER {
    const val LOGGER = "5.1.0"
    const val SLF4J = "2.0.9"

    /**
     * Deprecated
     */
    const val LOGBACK = "1.4.11"

    /**
     * Deprecated
     */
    const val KTOR = "2.3.2"


    /**
     * Deprecated
     */
    const val LOG4J = "2.20.0"
}

dependencies {
    /**
     * slf4j-impl only need one
     */
//    implementation("org.slf4j:slf4j-api:${VER.SLF4J}")
//    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
//    implementation("org.slf4j:slf4j-simple:${VER.SLF4J}")
//    implementation("ch.qos.logback:logback-classic:${VER.LOGBACK}")
//    implementation("org.slf4j:slf4j-reload4j:${VER.SLF4J}")
//    implementation("org.slf4j:slf4j-jcl:${VER.SLF4J}")
    /**
     * Deprecated
     */
//    implementation("org.apache.logging.log4j:log4j-slf4j-impl:${VER.LOG4J}")
//    implementation("io.github.oshai:kotlin-logging-jvm:${VER.LOGGER}")
    /**
     * http
     */
//    implementation(" io.ktor:ktor-server:${VER.KTOR}")
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-auth-jvm")
    implementation("io.ktor:ktor-server-auth-jwt-jvm")
    implementation("io.ktor:ktor-server-cors-jvm")
    implementation("io.ktor:ktor-server-openapi")
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-server-html-builder-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
//    implementation("ch.qos.logback:logback-classic:${VER.logback_version}")
    testImplementation("io.ktor:ktor-server-tests-jvm")
//    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    /**
     * db
     */
    // Kotlin coroutine dependency
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")

    // MongoDB Kotlin driver dependency
    implementation("org.mongodb:mongodb-driver-kotlin-coroutine:$mongodbVersion")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

allprojects {
    repositories {
        maven("https://maven.aliyun.com/repository/public/")
        maven("https://maven.aliyun.com/repository/central")
        maven("https://maven.aliyun.com/repository/gradle-plugin")
        maven("https://maven.aliyun.com/repository/apache-snapshots")
        mavenLocal()
//        mavenCentral()
    }
}

