package com.eygraber.galgal.services.splash.screen

interface SplashScreenController {
  fun init(isAppRestoring: Boolean)

  suspend fun awaitSystemSplashRemoved()
}
