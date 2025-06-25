package com.eygraber.galgal.apps.shared

import me.tatarka.inject.annotations.Inject

internal expect fun GalgalInitializer.initializeEnvironment()

@Inject
class GalgalInitializer {
  fun initialize() {
    initializeEnvironment()
  }
}
