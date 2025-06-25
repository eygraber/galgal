plugins {
  alias(libs.plugins.conventionsAndroidLibrary)
  alias(libs.plugins.conventionsComposeMultiplatform)
  alias(libs.plugins.conventionsDetekt)
  alias(libs.plugins.conventionsKotlinMultiplatform)
  alias(libs.plugins.conventionsProjectCommon)
  alias(libs.plugins.dependencyAnalysis)
}

android {
  namespace = "com.eygraber.galgal.compose.preview"
}

kotlin {
  defaultKmpTargets(
    project = project,
  )

  sourceSets {
    commonMain.dependencies {
      implementation(compose.runtime)
    }

    jvmMain.dependencies {
      api(compose.desktop.currentOs)
    }
  }
}
