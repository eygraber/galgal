plugins {
  alias(libs.plugins.conventionsAndroidLibrary)
  alias(libs.plugins.conventionsComposeMultiplatform)
  alias(libs.plugins.conventionsDetekt)
  alias(libs.plugins.conventionsKotlinMultiplatform)
  alias(libs.plugins.conventionsProjectCommon)
  alias(libs.plugins.dependencyAnalysis)
}

android {
  namespace = "com.eygraber.galgal.common"
}

kotlin {
  defaultKmpTargets(
    project = project,
  )

  sourceSets {
    commonMain.dependencies {
      implementation(compose.components.resources)
      implementation(compose.runtime)
    }
  }
}

compose.resources {
  publicResClass = true
  packageOfResClass = "com.eygraber.galgal.common"
  generateResClass = always
}
