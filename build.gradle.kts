plugins {
    id("java")
    id("io.qameta.allure") version "3.0.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.codeborne:selenide:7.11.1")
    testImplementation("io.qameta.allure:allure-selenide:2.30.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

allure {
    version.set("2.34.1")
    report {
        reportDir.set(project.reporting.baseDirectory.dir("allure-report"))
        singleFile = true
    }
    adapter {
        allureJavaVersion.set("2.29.1")
        aspectjVersion.set("1.9.22.1")
        autoconfigure.set(true)
        autoconfigureListeners.set(true)
        aspectjWeaver.set(true)

        frameworks {
            junit5 {
                // Defaults to allureJavaVersion
                adapterVersion.set("2.29.1")
                enabled.set(true)
                // Enables allure-junit4 default test listeners via META-INF/services/...
                autoconfigureListeners.set(true)
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
    systemProperties(System.getProperties() as Map<String?, *>)
}