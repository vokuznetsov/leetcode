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
    //apply(plugin = "io.gitlab.arturbosch.detekt")

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
        implementation("org.jetbrains.kotlin:kotlin-stdlib")
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

//    detekt {
//        toolVersion = "1.17.1"
//        input = files("src/main/kotlin", "src/test/kotlin")
//        autoCorrect = true
//    }
}
