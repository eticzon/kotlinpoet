import org.jetbrains.dokka.gradle.DokkaTask

plugins {
  kotlin("jvm") version "1.3.21"
  id("org.jetbrains.dokka") version "0.9.17"
  id("com.vanniktech.maven.publish") version "0.8.0"
}

val GROUP: String by project
val VERSION_NAME: String by project

group = GROUP
version = VERSION_NAME

tasks.named<Jar>("jar") {
  manifest {
    attributes("Automatic-Module-Name" to "com.squareup.kotlinpoet")
  }
}

afterEvaluate {
  tasks.named<DokkaTask>("dokka") {
    skipDeprecated = true
    outputFormat = "html"
  }
}

dependencies {
  api("org.jetbrains.kotlin:kotlin-stdlib-jdk7")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
  testImplementation("com.google.truth:truth:0.42")
  testImplementation("com.google.testing.compile:compile-testing:0.15")
  testImplementation("com.google.jimfs:jimfs:1.1")
  testImplementation("org.eclipse.jdt.core.compiler:ecj:4.6.1")
}

repositories {
  mavenCentral()
}
