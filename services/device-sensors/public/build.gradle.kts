plugins {
  alias(libs.plugins.conventionsAndroidLibrary)
  alias(libs.plugins.conventionsDetekt)
  alias(libs.plugins.conventionsKotlinMultiplatform)
  alias(libs.plugins.conventionsProjectCommon)
  alias(libs.plugins.dependencyAnalysis)
}

android {
  namespace = "com.eygraber.galgal.services.device.sensors"
}

kotlin {
  defaultKmpTargets(
    project = project,
  )

  sourceSets {
    commonMain.dependencies {
      api(libs.kotlinx.coroutines.core)
    }
  }
}
