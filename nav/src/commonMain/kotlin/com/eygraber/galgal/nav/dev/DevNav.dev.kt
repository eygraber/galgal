package com.eygraber.galgal.nav.dev

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.eygraber.compose.material3.navigation.bottomSheet
import com.eygraber.galgal.destinations.dev.settings.DevSettingsDestinationComponent
import com.eygraber.galgal.destinations.dev.settings.DevSettingsNavigator
import com.eygraber.galgal.destinations.dev.settings.DevSettingsRoute
import com.eygraber.galgal.nav.GalgalNavComponent
import com.eygraber.vice.nav.viceComposable
import kotlinx.serialization.Serializable

@Serializable
internal object GalgalRoutesDevSettings

@OptIn(ExperimentalMaterial3Api::class)
internal fun NavGraphBuilder.galgalDevNavGraph(
  navComponent: GalgalNavComponent,
) {
  navigation<GalgalRoutesDevSettings>(
    startDestination = DevSettingsRoute,
  ) {
    bottomSheet<DevSettingsRoute>(
      modalBottomSheetProperties = ModalBottomSheetDefaults.properties,
      skipPartiallyExpanded = false,
    ) {
      val devNavController = rememberNavController()
      NavHost(
        navController = devNavController,
        startDestination = DevSettingsRoute,
        enterTransition = { slideInVertically(tween(500)) { it * 2 } },
        popEnterTransition = { slideInHorizontally(tween(500)) { -it } },
        popExitTransition = { slideOutHorizontally(tween(500)) { it * 2 } },
        exitTransition = { slideOutVertically(tween(500)) { it * 2 } },
      ) {
        navGraph(
          navComponent = navComponent,
          navController = devNavController,
        )
      }
    }
  }
}

private fun NavGraphBuilder.navGraph(
  navComponent: GalgalNavComponent,
  navController: NavController,
) {
  viceComposable<DevSettingsRoute>(
    enterTransition = { slideInVertically { it * 2 } },
    exitTransition = { slideOutVertically { it * 2 } },
  ) { entry ->
    navComponent.devSettingsFactory.createDevSettingsComponent(
      navigator = DevSettingsNavigator(
        onNavigateBack = { navController.popBackStack() },
      ),
      route = entry.route,
    ).destination
  }
}

private val GalgalNavComponent.devSettingsFactory
  get() = this as DevSettingsDestinationComponent.Factory
