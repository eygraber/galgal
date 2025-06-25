package com.eygraber.galgal.app.init

import android.content.Context
import androidx.startup.Initializer
import com.eygraber.galgal.app.GalgalApplication

class GalgalAndroidXInitializer : Initializer<Unit> {
  override fun create(context: Context) {
    (context as GalgalApplication).component.initializer.initialize()
  }

  override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
