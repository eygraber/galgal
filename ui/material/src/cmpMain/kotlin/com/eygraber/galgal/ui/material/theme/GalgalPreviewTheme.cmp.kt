package com.eygraber.galgal.ui.material.theme

import androidx.compose.runtime.Composable

@Composable
actual fun GalgalEdgeToEdgePreviewTheme(
  isDarkMode: Boolean,
  content: @Composable () -> Unit,
) {
  GalgalPreviewTheme(
    isDarkMode = isDarkMode,
    content = content,
  )
}
