package com.eygraber.galgal.destinations.dev.settings

class DevSettingsNavigator(
  private val onNavigateBack: () -> Unit,
) {
  fun navigateBack() {
    onNavigateBack()
  }
}
