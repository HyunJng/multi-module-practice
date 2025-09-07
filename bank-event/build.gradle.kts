plugins {
    kotlin("plugin.spring")
}

dependencies {
    implementation(project(":bank-domain"))

    // spring
    implementation("org.springframework.boot:spring-boot-starter")

    // log
    implementation("ch.qos.logback:logback-classic")
}