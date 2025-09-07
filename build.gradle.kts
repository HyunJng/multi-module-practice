plugins {
	kotlin("jvm") version "2.0.21"
}

group = "org.multiodule"
version = "0.0.1-SNAPSHOT"
description = "multi-module-practice"

repositories {
	mavenCentral()
}

dependencies {
	testImplementation(kotlin("test"))
}

tasks.test {{
	useJUnitPlatform()
}}

kotlin {
	jvmToolchain(17)
}