
java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencies {

    testImplementation("org.junit.jupiter:junit-jupiter:${property("junitVersion")}")
}

tasks.test {
    useJUnitPlatform()
}