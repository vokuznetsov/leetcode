plugins {
    kotlin("jvm") version "1.3.10"
    idea
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
}

group = "leetcode"


extra.apply {
    set("junitVersion", "1.3.10")
}

subprojects {
    group = "${rootProject.group}.${rootProject.name}"

    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {
        implementation(kotlin("stdlib"))
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }
}
