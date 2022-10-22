plugins {
    application
}

group = "ru.gamesphere"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.inject:guice:5.1.0")
}

application {
    mainClass.set("ru.gamesphere.Main")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

