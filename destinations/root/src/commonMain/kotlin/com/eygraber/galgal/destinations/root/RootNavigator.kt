package com.eygraber.galgal.destinations.root

class RootNavigator(
  private val onNavigateToOnboarding: () -> Unit,
) {
  fun navigateToOnboarding() {
    onNavigateToOnboarding()
  }
}
