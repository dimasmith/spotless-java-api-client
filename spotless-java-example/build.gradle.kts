plugins {
    id("spotless.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":spotless-java"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    // Use `./gradlew :spotless-java-example:run` to run `Main`
    // Use `./gradlew :spotless-java-example:run -Dexample=Something` to run `SomethingExample`
    mainClass = "dev.knopitoshka.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
