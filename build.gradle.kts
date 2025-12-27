plugins {
    id("java")
}

group = "com.gerard"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("io.projectreactor:reactor-core")
    implementation ("io.projectreactor.netty:reactor-netty-core")
    implementation ("io.projectreactor.netty:reactor-netty-http")
    implementation("org.reactivestreams:reactive-streams:1.0.4")
    testImplementation ("io.projectreactor:reactor-test")
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.10.1")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.10.1")
    implementation("org.slf4j:slf4j-api:2.0.13")
    runtimeOnly("ch.qos.logback:logback-classic:1.5.13")
    implementation("com.github.javafaker:javafaker:1.0.2")
    testImplementation ("io.projectreactor:reactor-test")
}

tasks.test {
    useJUnitPlatform()
}