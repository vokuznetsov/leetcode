
java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:${property("junitVersion")}")

}

tasks.test {
    useJUnitPlatform()
}