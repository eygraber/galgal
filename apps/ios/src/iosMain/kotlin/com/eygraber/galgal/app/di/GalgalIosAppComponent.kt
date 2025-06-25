package com.eygraber.galgal.app.di

import com.eygraber.galgal.apps.shared.GalgalInitializer
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.MergeComponent
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn
import kotlin.reflect.KClass

@MergeComponent(AppScope::class)
@SingleIn(AppScope::class)
abstract class GalgalIosAppComponent : GalgalIosViewControllerComponent.Factory {
  abstract val initializer: GalgalInitializer
}

@MergeComponent.CreateComponent
expect fun KClass<GalgalIosAppComponent>.createKmp(): GalgalIosAppComponent
