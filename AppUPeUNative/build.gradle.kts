// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
        classpath(Dependencies.daggerHilt)
        classpath(Dependencies.ktLint)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}


/*task clean(type: Delete) {
    delete rootProject.buildDir
}*/
tasks.register("clean", Delete::class) {
    delete (rootProject.buildDir)
}