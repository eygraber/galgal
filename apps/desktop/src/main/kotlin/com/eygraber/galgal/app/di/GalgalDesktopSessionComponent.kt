package com.eygraber.galgal.app.di

import com.eygraber.galgal.di.scopes.SessionScope
import com.eygraber.galgal.nav.GalgalNavComponent
import com.eygraber.galgal.services.splash.screen.SplashScreenController
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.ContributesSubcomponent
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

@ContributesSubcomponent(SessionScope::class)
@SingleIn(SessionScope::class)
interface GalgalDesktopSessionComponent : GalgalNavComponent.Factory {
  val splashScreenController: SplashScreenController

  @ContributesSubcomponent.Factory(AppScope::class)
  interface Factory {
    fun createGalgalDesktopSessionComponent(): GalgalDesktopSessionComponent
  }
}
