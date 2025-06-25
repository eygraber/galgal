package com.eygraber.galgal.ui.material.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

@Composable
fun galgalLightColorScheme(): ColorScheme =
  lightColorScheme(
    primary = GalgalColors.lightPrimary,
    onPrimary = GalgalColors.lightOnPrimary,
    primaryContainer = GalgalColors.lightPrimaryContainer,
    onPrimaryContainer = GalgalColors.lightOnPrimaryContainer,
    secondary = GalgalColors.lightSecondary,
    onSecondary = GalgalColors.lightOnSecondary,
    secondaryContainer = GalgalColors.lightSecondaryContainer,
    onSecondaryContainer = GalgalColors.lightOnSecondaryContainer,
    tertiary = GalgalColors.lightTertiary,
    onTertiary = GalgalColors.lightOnTertiary,
    tertiaryContainer = GalgalColors.lightTertiaryContainer,
    onTertiaryContainer = GalgalColors.lightOnTertiaryContainer,
    error = GalgalColors.lightError,
    onError = GalgalColors.lightOnError,
    errorContainer = GalgalColors.lightErrorContainer,
    onErrorContainer = GalgalColors.lightOnErrorContainer,
    background = GalgalColors.lightBackground,
    onBackground = GalgalColors.lightOnBackground,
    surface = GalgalColors.lightSurface,
    surfaceVariant = GalgalColors.lightSurfaceVariant,
    surfaceContainerLowest = GalgalColors.lightSurfaceContainerLowest,
    surfaceContainerLow = GalgalColors.lightSurfaceContainerLow,
    surfaceContainer = GalgalColors.lightSurfaceContainer,
    surfaceContainerHigh = GalgalColors.lightSurfaceContainerHigh,
    surfaceContainerHighest = GalgalColors.lightSurfaceContainerHighest,
    surfaceBright = GalgalColors.lightSurfaceBright,
    surfaceDim = GalgalColors.lightSurfaceDim,
    onSurface = GalgalColors.lightOnSurface,
    onSurfaceVariant = GalgalColors.lightOnSurfaceVariant,
    inverseSurface = GalgalColors.lightInverseSurface,
    inverseOnSurface = GalgalColors.lightInverseOnSurface,
    inversePrimary = GalgalColors.lightInversePrimary,
  )
