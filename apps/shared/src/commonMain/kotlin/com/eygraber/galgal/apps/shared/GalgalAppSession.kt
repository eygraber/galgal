package com.eygraber.galgal.apps.shared

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.eygraber.galgal.nav.GalgalNav
import com.eygraber.galgal.nav.GalgalNavComponent
import com.eygraber.galgal.ui.material.theme.GalgalTheme
import com.eygraber.galgal.ui.material.theme.SystemDarkModeOverride

@Composable
fun GalgalAppSession(
  onDarkMode: @Composable (Boolean) -> Unit,
  navComponent: GalgalNavComponent,
  modifier: Modifier = Modifier,
) {
  val isDarkMode = when(SystemDarkModeOverride.rememberState()) {
    SystemDarkModeOverride.None -> isSystemInDarkTheme()
    SystemDarkModeOverride.Dark -> true
    SystemDarkModeOverride.Light -> false
  }

  onDarkMode(isDarkMode)

  Content(
    isDarkMode = isDarkMode,
    navComponent = navComponent,
    modifier = modifier,
  )
}

@Suppress("ModifierNotUsedAtRoot")
@Composable
private fun Content(
  isDarkMode: Boolean,
  navComponent: GalgalNavComponent,
  modifier: Modifier = Modifier,
) {
  GalgalTheme(
    isDarkMode = isDarkMode,
  ) {
    Surface(
      modifier = Modifier.fillMaxSize(),
    ) {
      Box(modifier = modifier) {
        GalgalNav(
          navComponent = navComponent,
        )
      }
    }
  }
}
