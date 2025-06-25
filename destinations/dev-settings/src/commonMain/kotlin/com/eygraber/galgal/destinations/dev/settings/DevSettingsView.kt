package com.eygraber.galgal.destinations.dev.settings

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.eygraber.galgal.ui.material.theme.GalgalEdgeToEdgeModalBottomSheetPreviewTheme
import com.eygraber.vice.ViceView

internal typealias DevSettingsView = ViceView<DevSettingsIntent, DevSettingsViewState>

@Suppress("UNUSED_PARAMETER")
@Composable
internal fun DevSettingsView(
  state: DevSettingsViewState,
  onIntent: (DevSettingsIntent) -> Unit,
) {
  Box(
    modifier = Modifier
      .fillMaxSize(),
  ) {
    Text("DevSettings")
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun DevSettingsPreview() {
  GalgalEdgeToEdgeModalBottomSheetPreviewTheme {
    DevSettingsView(
      state = DevSettingsViewState,
      onIntent = {},
    )
  }
}
