plugins {
    kotlin("jvm") version "1.9.21"
}

group = "org.dustbins"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

object VER {
    const val LOGGER = "5.1.0"
    const val SLF4J = "2.0.9"
    const val LOGBACK = "1.4.8"


    /**
     * Deprecated
     */
    const val LOG4J = "2.20.0"
}

dependencies {
    /**
     * slf4j-impl only need one
     */
    implementation("org.slf4j:slf4j-api:${VER.SLF4J}")
//    implementation("org.slf4j:slf4j-simple:${VER.SLF4J}")
    implementation("ch.qos.logback:logback-classic:${VER.LOGBACK}")
//    implementation("org.slf4j:slf4j-reload4j:${VER.SLF4J}")
//    implementation("org.slf4j:slf4j-jcl:${VER.SLF4J}")
    /**
     * Deprecated
     */
//    implementation("org.apache.logging.log4j:log4j-slf4j-impl:${VER.LOG4J}")
    implementation("io.github.oshai:kotlin-logging-jvm:${VER.LOGGER}")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
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

