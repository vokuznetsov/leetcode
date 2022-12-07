plugins {
    kotlin("jvm") version "1.6.10"
    id("io.gitlab.arturbosch.detekt") version "1.17.1"
    idea
}

group = "leetcode"

java.sourceCompatibility = JavaVersion.VERSION_11

subprojects {
    group = "${rootProject.group}.${rootProject.name}"

    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {

    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }
}
