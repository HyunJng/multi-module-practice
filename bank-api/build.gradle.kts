plugins {
    id("org.springframework.boot")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

dependencies {
    implementation(project(":bank-core"))
    implementation(project(":bank-domain"))
    implementation(project(":bank-event"))

    // spring
    implementation("org.springframework.boot:spring-boot-starter-web")

    // swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

    // log
    implementation("ch.qos.logback:logback-classic")
}