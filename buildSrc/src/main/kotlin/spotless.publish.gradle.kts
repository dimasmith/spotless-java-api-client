plugins {
    `maven-publish`
    signing
}

configure<PublishingExtension> {
    publications {
        register<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("Chessbot API")
                description.set("Toy API for a chess bot that can validate chess moves and do unrelated stuff.")
                url.set("https://www.github.com/dimasmith/spotless-java-api-client")

                licenses {
                    license {
                        name.set("MIT")
                    }
                }

                developers {
                    developer {
                        name.set("Spotless")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/dimasmith/spotless-java-api-client.git")
                    developerConnection.set("scm:git:git://github.com/dimasmith/spotless-java-api-client.git")
                    url.set("https://github.com/dimasmith/spotless-java-api-client")
                }

                versionMapping {
                    allVariants {
                        fromResolutionResult()
                    }
                }
            }
        }
    }
}

signing {
    val signingKeyId = System.getenv("GPG_SIGNING_KEY_ID")?.ifBlank { null }
    val signingKey = System.getenv("GPG_SIGNING_KEY")?.ifBlank { null }
    val signingPassword = System.getenv("GPG_SIGNING_PASSWORD")?.ifBlank { null }
    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(
            signingKeyId,
            signingKey,
            signingPassword,
        )
        sign(publishing.publications["maven"])
    }
}

tasks.named("publish") {
    dependsOn(":closeAndReleaseSonatypeStagingRepository")
}
