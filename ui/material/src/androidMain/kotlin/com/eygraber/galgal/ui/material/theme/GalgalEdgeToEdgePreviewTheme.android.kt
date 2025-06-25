package com.eygraber.galgal.ui.material.theme

import androidx.compose.runtime.Composable
import de.drick.compose.edgetoedgepreviewlib.EdgeToEdgeTemplate
import de.drick.compose.edgetoedgepreviewlib.NavigationMode

@Composable
actual fun GalgalEdgeToEdgePreviewTheme(
  isDarkMode: Boolean,
  content: @Composable () -> Unit,
) {
  EdgeToEdgeTemplate(
    navMode = NavigationMode.Gesture,
    isDarkMode = isDarkMode,
    showInsetsBorder = false,
  ) {
    GalgalPreviewTheme(
      isDarkMode = isDarkMode,
      content = content,
    )
  }
}
