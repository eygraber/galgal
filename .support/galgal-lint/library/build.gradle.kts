import com.vanniktech.maven.publish.AndroidSingleVariantLibrary

plugins {
  alias(libs.plugins.kotlinAndroid)
  alias(libs.plugins.conventionsAndroidLibrary)
  alias(libs.plugins.conventionsKotlin)
  alias(libs.plugins.dependencyAnalysis)
  alias(libs.plugins.mavenPublish)
}

group = "com.eygraber.galgal.lint"
version = "0.0.1"

android {
  namespace = "com.eygraber.galgal.lint"

  lint {
    checkDependencies = true
  }
}

dependencies {
  lintPublish(projects.checks)
}

mavenPublishing {
  configure(
    AndroidSingleVariantLibrary(
      variant = "release",
      sourcesJar = false,
      publishJavadocJar = false,
    ),
  )
}

publishing {
  repositories {
    maven {
      name = "projectLocal"
      url = uri("${rootDir.absolutePath}/../.m2")
    }
  }
}
