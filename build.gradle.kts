plugins {
    // Apply the Java plugin
    java
    // Apply the JaCoCo plugin
    id("jacoco")
    // Apply the SonarQube plugin
    id("org.sonarqube") version "3.3"
}

group = "com.example" // Replace with your group name
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral() // Use Maven Central for dependencies
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.8.2") // JUnit 5 for testing
}

// JaCoCo configuration
jacoco {
    toolVersion = "0.8.7" // Ensure you're using the correct version
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
        property("sonar.projectKey", "bhos-qa_lab-3-EsmiraFarziyeva2004") // Project key for SonarCloud
        property("sonar.organization", "bhos-qa") // Your SonarCloud organization
        property("sonar.host.url", "https://sonarcloud.io") // SonarCloud URL
        property("sonar.login", "7cc9d43866d8aad7fc6f68f7cb356ada7a12fc31") // Replace with your actual SonarCloud token
        property("sonar.language", "java") // Language of the project
        property("sonar.sources", "app/src/main") // Source directory for SonarCloud
        property("sonar.java.binaries", "app/build/classes/java/main") // Binaries directory for SonarCloud
        property("sonar.java.libraries", "app/build/libs/*.jar") // Libraries path for SonarCloud
        property("sonar.coverage.jacoco.xmlReportPaths", "app/build/reports/jacoco/test/jacocoTestReport.xml") // JaCoCo report path
    }
}
