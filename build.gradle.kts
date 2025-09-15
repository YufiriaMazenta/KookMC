plugins {
    java
    `maven-publish`
    id("com.github.johnrengelman.shadow").version("7.1.2")
}

group = "pers.yufiria"
version = "1.0.2"
java.sourceCompatibility = JavaVersion.VERSION_17


repositories {
    mavenCentral()
    //CrypticLib, FoliaAPI
    maven("https://repo.crypticlib.com:8081/repository/maven-public/")
    maven("https://jitpack.io")
    maven("https://repo.papermc.io/repository/maven-public/")
    //LiteCommands
    maven("https://repo.panda-lang.org/releases")
    maven("https://oss.sonatype.org/content/groups/public/")
}


dependencies {
    compileOnly("dev.folia:folia-api:1.20.2")
    implementation("com.crypticlib:bukkit:1.13.11.0")
    implementation("com.github.SNWCreations:KookBC:0.32.2")
}

java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8

publishing {
    var repositoryUrl = "https://repo.crypticlib.com:8081/repository/"
    repositoryUrl = if (rootProject.version.toString().endsWith("SNAPSHOT")) {
        repositoryUrl.plus("maven-snapshots/")
    } else {
        repositoryUrl.plus("maven-releases/")
    }
    publications.create<MavenPublication>("maven") {
        from(components["java"])
        groupId = rootProject.group as String?
    }
    repositories {
        maven {
            url = uri(repositoryUrl)
            isAllowInsecureProtocol = true
            credentials {
                username = project.findProperty("maven_username").toString()
                password = project.findProperty("maven_password").toString()
            }
        }
    }
}

tasks.withType(JavaCompile::class.java) {
    options.encoding = "UTF-8"
}

tasks {
    val props = HashMap<String, String>()
    props["version"] = version.toString()
    processResources {
        filesMatching("plugin.yml") {
            expand(props)
        }
        filesMatching("config.yml") {
            expand(props)
        }
    }
    build {
        dependsOn(shadowJar)
    }
    shadowJar {
        relocate("com.google.gson", "pers.yufiria.kookmc.libs.gson")
        relocate("org.yaml.snakeyaml", "pers.yufiria.kookmc.libs.snakeyaml")
        relocate("crypticlib", "pers.yufiria.kookmc.libs.crypticlib")
        relocate("com.google", "pers.yufiria.kookmc.libs.com.google")
        relocate("org.spongepowered", "pers.yufiria.kookmc.libs.org.spongepowered")

        relocate("org.intellij", "pers.yufiria.kookmc.libs.org.intellij")
        relocate("org.jline", "pers.yufiria.kookmc.libs.org.jline")
        relocate("org.checkframework", "pers.yufiria.kookmc.libs.org.checkframework")
        relocate("org.fusesource", "pers.yufiria.kookmc.libs.org.fusesource")
        relocate("net.minecrell", "pers.yufiria.kookmc.libs.net.minecrell")
        relocate("net.kyori", "pers.yufiria.kookmc.libs.net.kyori")
        relocate("kotlin", "pers.yufiria.kookmc.libs.kotlin")
        exclude("META-INF/versions/**")
        dependencies {
            exclude(dependency("org.slf4j:slf4j-api:.*"))
            exclude(dependency("org.apache.logging.log4j:log4j-api:.*"))
            exclude(dependency("org.apache.logging.log4j:log4j-core:.*"))
            exclude(dependency("org.apache.logging.log4j:log4j-slf4j-impl:.*"))
            exclude(dependency("uk.org.lidalia:sysout-over-slf4j:.*"))
            exclude(dependency("org.jetbrains:annotations:.*"))
        }
        archiveFileName.set("${rootProject.name}-${version}.jar")
    }
    compileJava {
        dependsOn(clean)
    }
}