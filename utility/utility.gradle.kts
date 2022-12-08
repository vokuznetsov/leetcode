
java.sourceCompatibility = JavaVersion.VERSION_11

dependencies {
    // Other dependencies.
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}