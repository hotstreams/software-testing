plugins {
    kotlin("jvm") version "1.4.10"
}

group = "org.ifmo.se.tpo"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("junit:junit:4.12")
}

tasks.withType<Test> {
    useJUnit()
}
