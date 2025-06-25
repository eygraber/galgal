package com.eygraber.galgal.destinations.welcome

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.eygraber.galgal.ui.compose.WithMaxDensity
import com.eygraber.galgal.ui.compose.sharedSplashScreenIcon
import com.eygraber.galgal.ui.icons.GalgalIcons
import com.eygraber.galgal.ui.icons.Logo
import com.eygraber.galgal.ui.material.theme.GalgalDarkTheme
import com.eygraber.galgal.ui.material.theme.GalgalPreviewTheme
import com.eygraber.vice.ViceView
import org.jetbrains.compose.resources.stringResource

internal typealias WelcomeView = ViceView<WelcomeIntent, WelcomeViewState>

@Suppress("UNUSED_PARAMETER")
@Composable
internal fun WelcomeView(
  state: WelcomeViewState,
  onIntent: (WelcomeIntent) -> Unit,
) {
  GalgalDarkTheme {
    Scaffold { contentPadding ->
      Box(
        modifier = Modifier.fillMaxSize(),
      ) {
        Column(
          modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding)
            .padding(horizontal = 16.dp),
          horizontalAlignment = Alignment.CenterHorizontally,
        ) {
          SplashScreenLogo(
            modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 32.dp),
          )

          WithMaxDensity(maxFontScale = 1.5F) {
            Text(
              text = stringResource(Res.string.onboarding_splash_title),
              textAlign = TextAlign.Center,
              style = MaterialTheme.typography.titleLarge,
            )

            Text(
              text = stringResource(Res.string.onboarding_splash_body),
              textAlign = TextAlign.Center,
              modifier = Modifier
                .padding(24.dp),
              style = MaterialTheme.typography.bodyLarge,
            )

            Spacer(modifier = Modifier.weight(1F))

            Button(
              onClick = { onIntent(WelcomeIntent.SignUp) },
              modifier = Modifier.fillMaxWidth(),
            ) {
              Text(stringResource(Res.string.onboarding_splash_sign_up))
            }

            Spacer(modifier = Modifier.height(8.dp))

            FilledTonalButton(
              onClick = { onIntent(WelcomeIntent.Login) },
              modifier = Modifier.fillMaxWidth(),
            ) {
              Text(stringResource(Res.string.onboarding_splash_login))
            }

            Text(
              text = stringResource(Res.string.onboarding_splash_privacy_tos),
              textAlign = TextAlign.Center,
              modifier = Modifier.padding(8.dp),
              style = MaterialTheme.typography.bodySmall,
            )
          }
        }
      }
    }
  }
}

@Composable
private fun SplashScreenLogo(
  modifier: Modifier = Modifier,
) {
  Box(
    modifier = modifier,
    contentAlignment = Alignment.TopCenter,
  ) {
    Icon(
      GalgalIcons.Logo,
      contentDescription = null,
      modifier = Modifier
        .sharedSplashScreenIcon(),
    )
  }
}

@Preview
@Composable
private fun WelcomePreview() {
  GalgalPreviewTheme {
    WelcomeView(
      state = WelcomeViewState,
      onIntent = {},
    )
  }
}
