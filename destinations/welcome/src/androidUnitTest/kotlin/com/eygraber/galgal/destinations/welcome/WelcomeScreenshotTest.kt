package com.eygraber.galgal.destinations.welcome

import app.cash.paparazzi.Paparazzi
import com.eygraber.galgal.test.utils.PaparazziComposeResourcesEffect
import com.eygraber.galgal.test.utils.PaparazziDeviceConfig
import com.eygraber.galgal.ui.material.theme.GalgalEdgeToEdgePreviewTheme
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(TestParameterInjector::class)
class WelcomeScreenshotTest(
  @TestParameter
  private val deviceConfig: PaparazziDeviceConfig,
) {
  @get:Rule
  val paparazzi = Paparazzi(
    deviceConfig = deviceConfig.config,
  )

  @Test
  fun screenshot() {
    paparazzi.snapshot {
      PaparazziComposeResourcesEffect()

      GalgalEdgeToEdgePreviewTheme(isDarkMode = deviceConfig.isDarkMode) {
        WelcomeView(
          state = WelcomeViewState,
          onIntent = {},
        )
      }
    }
  }
}
