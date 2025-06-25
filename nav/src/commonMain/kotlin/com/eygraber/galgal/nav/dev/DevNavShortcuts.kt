package com.eygraber.galgal.nav.dev

import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.isCtrlPressed
import androidx.compose.ui.input.key.key
import androidx.navigation.NavController
import com.eygraber.galgal.nav.NavShortcuts
import com.eygraber.galgal.nav.RealNavShortcutManager

internal fun RealNavShortcutManager.handleEnvironmentKeyEvent(event: KeyEvent): NavShortcuts? =
  when {
    event.isCtrlPressed && event.key == Key.M -> NavShortcuts.DevSettings
    else -> null
  }

internal fun NavShortcuts.handleEnvironment(
  navController: NavController,
) = when(this) {
  NavShortcuts.DevSettings -> {
    navController.navigate(GalgalRoutesDevSettings)
    true
  }
}
