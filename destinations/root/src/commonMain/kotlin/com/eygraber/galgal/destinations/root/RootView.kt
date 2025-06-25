package com.eygraber.galgal.destinations.root

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import com.eygraber.galgal.ui.compose.sharedSplashScreenIcon
import com.eygraber.galgal.ui.icons.GalgalIcons
import com.eygraber.galgal.ui.icons.Logo
import com.eygraber.galgal.ui.material.theme.GalgalDarkTheme
import com.eygraber.galgal.ui.material.theme.GalgalPreviewTheme
import com.eygraber.vice.ViceView
import org.jetbrains.compose.resources.stringResource

internal typealias RootView = ViceView<RootIntent, RootViewState>

@Composable
internal expect fun ReportDrawn()

@Suppress("UNUSED_PARAMETER")
@Composable
internal fun RootView(
  state: RootViewState,
  onIntent: (RootIntent) -> Unit,
) {
  ReportDrawn()

  GalgalDarkTheme {
    Surface(
      modifier = Modifier
        .fillMaxSize(),
    ) {
      Box(
        contentAlignment = Alignment.Center,
      ) {
        SplashIcon()
      }
    }
  }
}

@Composable
private fun SplashIcon() {
  Image(
    imageVector = GalgalIcons.Logo,
    contentDescription = stringResource(Res.string.root_cd_splash_icon),
    modifier = Modifier
      .sharedSplashScreenIcon(),
    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
  )
}

@Preview
@Composable
private fun RootPreview() {
  GalgalPreviewTheme {
    RootView(
      state = RootViewState,
      onIntent = {},
    )
  }
}
