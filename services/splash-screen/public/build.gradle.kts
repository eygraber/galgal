plugins {
  alias(libs.plugins.conventionsAndroidLibrary)
  alias(libs.plugins.conventionsDetekt)
  alias(libs.plugins.conventionsKotlinMultiplatform)
  alias(libs.plugins.conventionsProjectCommon)
  alias(libs.plugins.dependencyAnalysis)
}

android {
  namespace = "com.eygraber.galgal.services.splash.screen"
}

kotlin {
  defaultKmpTargets(
    project = project,
  )

  sourceSets {
    commonMain.dependencies {
      implementation(libs.kotlinx.coroutines.core)
    }
  }
}
