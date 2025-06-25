package com.eygraber.galgal.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.input.key.KeyEvent
import androidx.navigation.NavController
import com.eygraber.galgal.di.scopes.NavScope
import com.eygraber.galgal.nav.dev.handleEnvironment
import com.eygraber.galgal.nav.dev.handleEnvironmentKeyEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import me.tatarka.inject.annotations.Inject
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

interface NavShortcutManager {
  val shortcutFlow: Flow<NavShortcuts>

  fun handleKeyEvent(event: KeyEvent): Boolean
}

enum class NavShortcuts {
  DevSettings,
}

@Inject
@SingleIn(NavScope::class)
@ContributesBinding(NavScope::class)
class RealNavShortcutManager : NavShortcutManager {
  private val shortcuts = MutableSharedFlow<NavShortcuts>(extraBufferCapacity = 1)

  override val shortcutFlow = shortcuts

  override fun handleKeyEvent(event: KeyEvent): Boolean =
    when(val environmentSpecificShortcut = handleEnvironmentKeyEvent(event)) {
      null -> false
      else -> {
        shortcuts.tryEmit(environmentSpecificShortcut)
        true
      }
    }
}

@Composable
internal fun HandleNavShortcutsEffect(
  navShortcutManager: NavShortcutManager,
  navController: NavController,
) {
  LaunchedEffect(Unit) {
    navShortcutManager.shortcutFlow.collect { shortcut ->
      shortcut.handleEnvironment(navController)
    }
  }
}
