plugins {
	id("org.springframework.boot") version "3.2.3" apply false
	id("io.spring.dependency-management") version "1.1.4" apply false
	kotlin("jvm") version "2.0.21" apply false
	kotlin("plugin.spring") version "2.0.21" apply false
	kotlin("plugin.jpa") version "2.0.21" apply false
}

allprojects {
	group = "org.multiodule"
	version = "0.0.1-SNAPSHOT"
	description = "multi-module-practice"

	repositories {
		mavenCentral()
	}
}


subprojects {
	apply(plugin = "kotlin")
	apply(plugin = "io.spring.dependency-management")

	if (name == "bank-core") {
		apply(plugin = "org.jetbrains.kotlin.plugin.spring")
	}

	if (name == "bank-domain") {
		apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

	tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
		kotlinOptions {
			jvmTarget = "17"
			freeCompilerArgs += "-Xjsr305=strict"
		}
	}
}