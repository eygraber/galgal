package com.eygraber.galgal.app

import android.app.Application
import com.eygraber.galgal.app.di.GalgalApplicationComponent
import com.eygraber.galgal.app.di.create

class GalgalApplication : Application() {
  val component by lazy {
    GalgalApplicationComponent::class.create(
      applicationDelegate = this,
    )
  }
}

internal val Application.galgalApplicationComponent get() = (this as GalgalApplication).component
