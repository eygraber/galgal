package com.eygraber.galgal.nav

import com.eygraber.galgal.di.scopes.NavScope
import com.eygraber.galgal.di.scopes.SessionScope
import com.eygraber.galgal.services.device.sensors.ShakeDetector
import software.amazon.lastmile.kotlin.inject.anvil.ContributesSubcomponent
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

@ContributesSubcomponent(NavScope::class)
@SingleIn(NavScope::class)
interface GalgalNavComponent {
  val shakeDetector: ShakeDetector
  val shortcutManager: NavShortcutManager

  @ContributesSubcomponent.Factory(SessionScope::class)
  interface Factory {
    fun createGalgalNavComponent(): GalgalNavComponent
  }
}
