package com.eygraber.galgal.nav.dev

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.eygraber.galgal.services.device.sensors.ShakeDetector
import kotlinx.coroutines.flow.filter

@Composable
internal fun DetectShakesEffect(
  shakeDetector: ShakeDetector,
  navController: NavController,
) {
  LaunchedEffect(Unit) {
    shakeDetector
      .detectShakes()
      .filter {
        // don't handle a shake if dev settings is already showing
        runCatching {
          navController.getBackStackEntry<GalgalRoutesDevSettings>()
        }.getOrNull() == null
      }
      .collect {
        navController.navigate(GalgalRoutesDevSettings)
      }
  }
}
