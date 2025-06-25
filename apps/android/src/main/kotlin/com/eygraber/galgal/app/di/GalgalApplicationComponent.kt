package com.eygraber.galgal.app.di

import android.app.Application
import com.eygraber.galgal.app.di.android.AndroidAppModule
import com.eygraber.galgal.apps.shared.GalgalInitializer
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.MergeComponent
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

@MergeComponent(AppScope::class)
@SingleIn(AppScope::class)
abstract class GalgalApplicationComponent(
  override val application: Application,
) : AndroidAppModule, GalgalActivityComponent.Factory {
  abstract val initializer: GalgalInitializer
}
