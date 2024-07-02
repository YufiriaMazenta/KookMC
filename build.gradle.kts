plugins {
    java
    `maven-publish`
    id("com.github.johnrengelman.shadow").version("7.1.2")
}

group = "pers.yufiria"
version = "1.0.1"
java.sourceCompatibility = JavaVersion.VERSION_17


repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.papermc.io/repository/maven-public/")
    //CrypticLib
    maven("http://repo.crypticlib.com:8081/repository/maven-public/") {
        isAllowInsecureProtocol = true
    }
    //LiteCommands
    maven("https://repo.panda-lang.org/releases")
    maven("https://oss.sonatype.org/content/groups/public/")
}


dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
    compileOnly("dev.folia:folia-api:1.20.1-R0.1-SNAPSHOT")
    implementation("com.crypticlib:common:0.18.10")
    implementation("com.github.SNWCreations:KookBC:0.30.2")
}

publishing {
    var repositoryUrl = "http://repo.crypticlib.com:8081/repository/"
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
        relocate("org.slf4j", "pers.yufiria.kookmc.libs.org.slf4j")
        relocate("org.intellij", "pers.yufiria.kookmc.libs.org.intellij")
        relocate("org.jline", "pers.yufiria.kookmc.libs.org.jline")
        relocate("org.checkframework", "pers.yufiria.kookmc.libs.org.checkframework")
        relocate("org.apache", "pers.yufiria.kookmc.libs.org.apache")
        relocate("org.fusesource", "pers.yufiria.kookmc.libs.org.fusesource")
        relocate("net.minecrell", "pers.yufiria.kookmc.libs.net.minecrell")
        relocate("net.kyori", "pers.yufiria.kookmc.libs.net.kyori")
        relocate("kotlin", "pers.yufiria.kookmc.libs.kotlin")

        archiveFileName.set("${rootProject.name}-${version}.jar")
    }
    compileJava {
        dependsOn(clean)
    }
}