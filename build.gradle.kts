import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.21"
    `maven-publish`
    signing
}

group = "com.hiczp"
version = "1.0"
description = "Use box-drawing character to make sentence"

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    testCompile("junit:junit:4.12")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
}

tasks.register<Jar>("sourcesJar") {
    from(sourceSets.main.get().allSource)
    archiveClassifier.set("sources")
}

tasks.register<Jar>("javadocJar") {
    from(tasks.javadoc)
    archiveClassifier.set("javadoc")
}

publishing {
    repositories {
        maven {
            url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = project.properties["ossUsername"].toString()
                password = project.properties["ossPassword"].toString()
            }
        }
    }

    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifact(tasks["sourcesJar"])
            artifact(tasks["javadocJar"])

            afterEvaluate {
                artifactId = tasks.jar.get().archiveBaseName.get()
            }

            pom {
                name.set(project.name)
                description.set(project.description)
                url.set("https://github.com/czp3009/box-drawing-art")

                licenses {
                    license {
                        name.set("GNU GENERAL PUBLIC LICENSE Version 3")
                        url.set("https://www.gnu.org/licenses/gpl-3.0.txt")
                    }
                }

                developers {
                    developer {
                        id.set("czp3009")
                        name.set("czp3009")
                        email.set("czp3009@gmail.com")
                        url.set("https://www.hiczp.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/czp3009/box-drawing-art")
                    developerConnection.set("scm:git:ssh://github.com/czp3009/box-drawing-art")
                    url.set("https://github.com/czp3009/box-drawing-art")
                }
            }
        }
    }
}

signing {
    sign(publishing.publications["mavenJava"])
}
