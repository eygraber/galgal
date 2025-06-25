package com.eygraber.galgal.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.awt.ComposeWindow
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.type
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import com.eygraber.galgal.app.di.GalgalDesktopAppComponent
import com.eygraber.galgal.app.di.create
import com.eygraber.galgal.apps.shared.GalgalAppSession
import java.awt.Dimension

fun main() {
  val appComponent = GalgalDesktopAppComponent::class.create()
  appComponent.initializer.initialize()

  val sessionComponent = appComponent.createGalgalDesktopSessionComponent()
  val navComponent = sessionComponent.createGalgalNavComponent()

  singleWindowApplication(
    state = WindowState(
      width = 400.dp,
      height = 800.dp,
    ),
    onPreviewKeyEvent = { event ->
      event.type == KeyEventType.KeyUp && navComponent.shortcutManager.handleKeyEvent(event)
    },
  ) {
    WindowMinSizeEffect(window)

    GalgalAppSession(
      onDarkMode = {},
      navComponent = navComponent,
    )
  }
}

@Composable
private fun WindowMinSizeEffect(
  window: ComposeWindow,
) {
  val minimumWindowSize = with(LocalDensity.current) {
    val minSize = DpSize(
      width = 400.dp,
      height = 800.dp,
    )
    remember(density, minSize) { Dimension(minSize.width.roundToPx(), minSize.height.roundToPx()) }
  }

  DisposableEffect(window, minimumWindowSize) {
    window.minimumSize = minimumWindowSize

    onDispose {}
  }
}
