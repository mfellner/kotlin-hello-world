buildscript {
  val springBootVersion = "2.0.0.BUILD-SNAPSHOT"
  val kotlinVersion = "1.1.0-beta-38"
  extra["kotlinVersion"] = kotlinVersion

  repositories {
    mavenCentral()
    maven { setUrl("https://repo.spring.io/snapshot") }
    maven { setUrl("https://repo.spring.io/milestone") }
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap-1.1") }
  }

  dependencies {
    classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
    classpath("org.jetbrains.kotlin:kotlin-noarg:$kotlinVersion")
    classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
  }
}

apply {
  plugin("idea")
  plugin("kotlin")
  plugin("kotlin-spring")
  plugin("kotlin-jpa")
  plugin("org.springframework.boot")
}

version = "0.1.0-SNAPSHOT"
group = "at.mfellner"

configure<JavaPluginConvention> {
  setSourceCompatibility(1.8)
  setTargetCompatibility(1.8)
}

repositories {
  mavenCentral()
  maven { setUrl("https://repo.spring.io/snapshot") }
  maven { setUrl("https://repo.spring.io/milestone") }
  maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap-1.1") }
}

val kotlinVersion = extra["kotlinVersion"] as String

dependencies {
  compile("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
  compile("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")

  compile("org.springframework.boot:spring-boot-starter-web")
  compile("org.springframework.boot:spring-boot-starter-undertow")
  compile("org.springframework.boot:spring-boot-starter-data-jpa")
  compile("com.h2database:h2")

  compile("com.fasterxml.jackson.core:jackson-databind")
  compile("com.fasterxml.jackson.module:jackson-module-kotlin")
  compile("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

  testCompile("org.springframework.boot:spring-boot-starter-test")
}
