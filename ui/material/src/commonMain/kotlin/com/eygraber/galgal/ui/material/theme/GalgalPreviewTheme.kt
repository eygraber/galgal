package com.eygraber.galgal.ui.material.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import com.eygraber.vice.nav.LocalAnimatedVisibilityScope
import com.eygraber.vice.nav.LocalSharedTransitionScope

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun GalgalPreviewTheme(
  isDarkMode: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit,
) {
  GalgalTheme(isDarkMode = isDarkMode) {
    SharedTransitionLayout {
      CompositionLocalProvider(
        LocalSharedTransitionScope provides this,
      ) {
        AnimatedVisibility(
          visible = true,
        ) {
          CompositionLocalProvider(
            LocalAnimatedVisibilityScope provides this,
            content = content,
          )
        }
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GalgalModalBottomSheetPreviewTheme(
  isDarkMode: Boolean = isSystemInDarkTheme(),
  skipPartiallyExpanded: Boolean = false,
  initialValue: SheetValue = SheetValue.PartiallyExpanded,
  properties: ModalBottomSheetProperties = ModalBottomSheetProperties(),
  content: @Composable ColumnScope.() -> Unit,
) {
  GalgalPreviewTheme(
    isDarkMode = isDarkMode,
  ) {
    ModalBottomSheetPreview(
      skipPartiallyExpanded = skipPartiallyExpanded,
      initialValue = initialValue,
      properties = properties,
      content = content,
    )
  }
}

@Composable
expect fun GalgalEdgeToEdgePreviewTheme(
  isDarkMode: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GalgalEdgeToEdgeModalBottomSheetPreviewTheme(
  isDarkMode: Boolean = isSystemInDarkTheme(),
  skipPartiallyExpanded: Boolean = false,
  initialValue: SheetValue = SheetValue.PartiallyExpanded,
  properties: ModalBottomSheetProperties = ModalBottomSheetProperties(),
  content: @Composable ColumnScope.() -> Unit,
) {
  GalgalEdgeToEdgePreviewTheme(
    isDarkMode = isDarkMode,
  ) {
    ModalBottomSheetPreview(
      skipPartiallyExpanded = skipPartiallyExpanded,
      initialValue = initialValue,
      properties = properties,
      content = content,
    )
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ModalBottomSheetPreview(
  skipPartiallyExpanded: Boolean,
  initialValue: SheetValue,
  properties: ModalBottomSheetProperties,
  content: @Composable ColumnScope.() -> Unit,
) {
  val density = LocalDensity.current
  val sheetState = remember {
    SheetState(
      skipPartiallyExpanded = skipPartiallyExpanded,
      density = density,
      initialValue = initialValue,
      skipHiddenState = false,
      confirmValueChange = { true },
    )
  }

  LaunchedEffect(sheetState) {
    if(initialValue == SheetValue.Expanded) {
      sheetState.expand()
    }
    else {
      sheetState.partialExpand()
    }
  }

  ModalBottomSheet(
    onDismissRequest = {},
    sheetState = sheetState,
    properties = properties,
    content = content,
  )
}
