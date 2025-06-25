package com.eygraber.galgal.app

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.InternalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.CanvasBasedWindow
import com.eygraber.galgal.app.di.GalgalWebAppComponent
import com.eygraber.galgal.app.di.create
import com.eygraber.galgal.apps.shared.GalgalAppSession
import kotlinx.browser.window
import org.jetbrains.compose.resources.configureWebResources

@OptIn(ExperimentalComposeUiApi::class, InternalComposeUiApi::class)
fun main() {
  val appComponent = GalgalWebAppComponent::class.create()
  appComponent.initializer.initialize()

  val sessionComponent = appComponent.createGalgalWebSessionComponent()
  val navComponent = sessionComponent.createGalgalNavComponent()

  configureWebResources {
    resourcePathMapping { path -> "/$path" }
  }

  // https://youtrack.jetbrains.com/issue/CMP-7166
  window.onkeyup = { event ->
    if(event.ctrlKey && event.key == "m") {
      navComponent.shortcutManager.handleKeyEvent(
        KeyEvent(
          key = Key.M,
          type = KeyEventType.KeyUp,
          isCtrlPressed = true,
        ),
      )
    }
  }

  CanvasBasedWindow("Galgal") {
    GalgalAppSession(
      onDarkMode = {},
      navComponent = navComponent,
      modifier = Modifier.padding(horizontal = 700.dp),
    )
  }
}
