package com.eygraber.galgal.apps.shared

import com.juul.khronicle.ConsoleLogger
import com.juul.khronicle.Log

internal actual fun GalgalInitializer.initializeEnvironment() {
  Log.dispatcher.install(ConsoleLogger)
}
