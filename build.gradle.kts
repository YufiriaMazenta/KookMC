plugins {
    java
    `maven-publish`
}

group = "com.github.yufiriamazenta"
version = "1.0.0-dev1"
java.sourceCompatibility = JavaVersion.VERSION_17


repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://oss.sonatype.org/content/groups/public/")
}


dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
    compileOnly("dev.folia:folia-api:1.20.1-R0.1-SNAPSHOT")
    compileOnly("com.github.YufiriaMazenta:ParettiaLib:c146db9a75")
    implementation("com.github.SNWCreations:KookBC:0.27.1")
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType(Jar::class.java) {
    project.configurations.getByName("implementation").isCanBeResolved = true
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    from(configurations.implementation.get().map { if (it.isDirectory) it else zipTree(it) })
}

tasks.withType(JavaCompile::class.java) {
    options.encoding = "UTF-8"
}

tasks {
    val props = HashMap<String, String>()
    props["version"] = version.toString()
    "processResources"(ProcessResources::class) {
        filesMatching("plugin.yml") {
            expand(props)
        }
        filesMatching("config.yml") {
            expand(props)
        }
    }
}