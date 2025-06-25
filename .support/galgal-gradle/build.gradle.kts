import com.eygraber.conventions.detekt.configureDetekt
import com.eygraber.conventions.kotlin.configureKgp
import com.eygraber.conventions.repositories.addCommonRepositories
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

buildscript {
  dependencies {
    classpath(galgalGradleLibs.buildscript.publish)
  }
}

plugins {
  `kotlin-dsl`
  alias(galgalGradleLibs.plugins.conventionsBase)
  alias(galgalGradleLibs.plugins.detekt)
  `maven-publish`
}

group = "com.eygraber.galgal.gradle"
version = "0.0.1"

val expectedJavaVersion = file("../../.github/.java-version").readText().trim()
val toolchainVersion: JavaLanguageVersion? = when {
  JavaVersion.current() < JavaVersion.toVersion(expectedJavaVersion.toInt()) ->
    JavaLanguageVersion.of(expectedJavaVersion)

  else -> null
}

val jvmTarget = JvmTarget.fromTarget(galgalGradleLibs.versions.jvmTarget.get())

configureKgp(
  jvmTargetVersion = jvmTarget,
  jdkToolchainVersion = toolchainVersion,
  jvmDistribution = JvmVendorSpec.AZUL.takeIf { toolchainVersion != null },
)

configureDetekt(
  jvmTargetVersion = jvmTarget,
  useRootConfigFile = false,
  useProjectConfigFile = false,
  configFiles = files("../../detekt.yml"),
)

repositories {
  addCommonRepositories(
    includeMavenCentral = true,
    includeMavenCentralSnapshots = true,
    includeGoogle = true,
    includeGradlePluginPortal = true,
  )
}

dependencies {
  // this monster is courtesy of https://github.com/gradle/gradle/issues/15383
  implementation(files(galgalGradleLibs.javaClass.superclass.protectionDomain.codeSource.location))

  implementation(galgalGradleLibs.buildscript.android)
  implementation(galgalGradleLibs.buildscript.ejson)
  implementation(galgalGradleLibs.buildscript.googleServices)
  implementation(galgalGradleLibs.buildscript.kotlin)
  implementation(galgalGradleLibs.buildscript.ksp)

  implementation(galgalGradleLibs.kotlinx.serialization.json)

  detektPlugins(galgalGradleLibs.detektCompose)
  detektPlugins(galgalGradleLibs.detektEygraber.formatting)
  detektPlugins(galgalGradleLibs.detektEygraber.style)
}

publishing {
  repositories {
    maven {
      name = "projectLocal"
      url = uri("../.m2")
    }
  }
}
