plugins {
    id("java")
}

group = "ru.gamesphere"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

}

allprojects {
    apply(plugin = "java")

    dependencies {
        implementation("com.intellij:annotations:12.0")
    }
}