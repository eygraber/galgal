plugins {
  alias(libs.plugins.conventionsAndroidLibrary)
  alias(libs.plugins.conventionsDetekt)
  alias(libs.plugins.conventionsKotlinMultiplatform)
  alias(libs.plugins.conventionsProjectCommon)
  alias(libs.plugins.dependencyAnalysis)
}

android {
  namespace = "com.eygraber.galgal.di"
}

kotlin {
  defaultKmpTargets(
    project = project,
  )

  sourceSets {
    androidMain.dependencies {
      implementation(libs.kotlinInject.runtime)
    }
  }
}
