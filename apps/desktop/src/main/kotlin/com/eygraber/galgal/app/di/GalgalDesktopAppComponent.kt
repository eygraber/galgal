package com.eygraber.galgal.app.di

import com.eygraber.galgal.apps.shared.GalgalInitializer
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.MergeComponent
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

@MergeComponent(AppScope::class)
@SingleIn(AppScope::class)
abstract class GalgalDesktopAppComponent : GalgalDesktopSessionComponent.Factory {
  abstract val initializer: GalgalInitializer
}
