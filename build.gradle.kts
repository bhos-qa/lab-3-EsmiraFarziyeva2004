plugins {
    // Apply the Java plugin
    java
    // Apply the JaCoCo plugin
    id("jacoco")
    // Apply the SonarQube plugin
    id("org.sonarqube") version "3.3" // Check for the latest version
}

group = "bhos-qa" // Replace with your group name
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral() // Use Maven Central for dependencies
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.8.2") // JUnit 5 for testing
}

// JaCoCo configuration
jacoco {
    toolVersion = "0.8.9" // Ensure you're using the correct version
}

tasks.jacocoTestReport {
    reports {
        xml.required.set(true) // Required for SonarCloud
        html.required.set(true) // For local reading
    }
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport) // Ensure the JaCoCo report runs after tests
}

// SonarQube configuration
sonarqube {
    properties {
        property("sonar.projectKey", "bhos-qa_lab-3-EsmiraFarziyeva2004")
        property("sonar.organization", "bhos-qa")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.login", "7cc9d43866d8aad7fc6f68f7cb356ada7a12fc31")
        property("sonar.sources", "src/main/java") // Updated to reflect the correct path
        property("sonar.java.binaries", "build/classes/java/main")
        property("sonar.java.libraries", "build/libs/*.jar")
        property("sonar.coverage.jacoco.xmlReportPaths", "build/reports/jacoco/test/jacocoTestReport.xml")
    }
}
