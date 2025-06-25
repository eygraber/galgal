package com.eygraber.galgal.nav

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.eygraber.compose.material3.navigation.ModalBottomSheetLayout
import com.eygraber.compose.material3.navigation.bottomSheet
import com.eygraber.compose.material3.navigation.rememberModalBottomSheetNavigator
import com.eygraber.galgal.destinations.root.RootDestinationComponent
import com.eygraber.galgal.destinations.root.RootNavigator
import com.eygraber.galgal.destinations.root.RootRoute
import com.eygraber.galgal.destinations.welcome.WelcomeDestinationComponent
import com.eygraber.galgal.destinations.welcome.WelcomeNavigator
import com.eygraber.galgal.destinations.welcome.WelcomeRoute
import com.eygraber.galgal.nav.dev.DetectShakesEffect
import com.eygraber.galgal.nav.dev.galgalDevNavGraph
import com.eygraber.vice.nav.LocalSharedTransitionScope
import com.eygraber.vice.nav.viceComposable
import kotlinx.serialization.Serializable

@OptIn(ExperimentalSharedTransitionApi::class, ExperimentalMaterial3Api::class)
@Composable
fun GalgalNav(
  navComponent: GalgalNavComponent,
) {
  val bottomSheetNavigator = rememberModalBottomSheetNavigator()
  val navController = rememberNavController(bottomSheetNavigator)

  DetectShakesEffect(
    shakeDetector = navComponent.shakeDetector,
    navController = navController,
  )

  HandleNavShortcutsEffect(
    navShortcutManager = navComponent.shortcutManager,
    navController = navController,
  )

  SharedTransitionLayout {
    CompositionLocalProvider(
      LocalSharedTransitionScope provides this,
    ) {
      ModalBottomSheetLayout(
        bottomSheetNavigator,
      ) {
        NavHost(
          navController = navController,
          startDestination = RootRoute,
          enterTransition = { slideInHorizontally(tween(500)) { it * 2 } },
          popEnterTransition = { slideInHorizontally(tween(500)) { -it } },
          popExitTransition = { slideOutHorizontally(tween(500)) { it * 2 } },
          exitTransition = { slideOutHorizontally(tween(500)) { -it } },
        ) {
          galgalNavGraph(
            navComponent = navComponent,
            navController = navController,
          )
        }
      }
    }
  }
}

private fun NavGraphBuilder.galgalNavGraph(
  navComponent: GalgalNavComponent,
  navController: NavController,
) {
  galgalDevNavGraph(
    navComponent = navComponent,
  )

  comingSoonRoute()

  viceComposable<RootRoute> { entry ->
    navComponent.rootFactory.createRootComponent(
      navigator = RootNavigator(
        onNavigateToOnboarding = {
          navController.navigate(GalgalRoutes.Onboarding) {
            popUpTo(RootRoute) {
              inclusive = true
            }
          }
        },
      ),
      route = entry.route,
    ).destination
  }

  onboardingNavGraph(
    navComponent = navComponent,
    navController = navController,
  )
}

private fun NavGraphBuilder.onboardingNavGraph(
  navComponent: GalgalNavComponent,
  navController: NavController,
) {
  navigation<GalgalRoutes.Onboarding>(
    startDestination = WelcomeRoute,
  ) {
    viceComposable<WelcomeRoute> { entry ->
      navComponent.welcomeFactory.createWelcomeComponent(
        navigator = WelcomeNavigator(
          onNavigateToSignUp = { navController.navigate(GalgalRoutes.ComingSoon("SignUp")) },
          onNavigateToLogin = { navController.navigate(GalgalRoutes.ComingSoon("Login")) },
        ),
        route = entry.route,
      ).destination
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
private fun NavGraphBuilder.comingSoonRoute() {
  bottomSheet<GalgalRoutes.ComingSoon> { entry ->
    val comingSoon = entry.toRoute<GalgalRoutes.ComingSoon>()
    Box(
      modifier = Modifier.padding(16.dp),
    ) {
      Text("${comingSoon.feature} coming soon!")
    }
  }
}

@Serializable
private sealed interface GalgalRoutes {
  @Serializable
  data class ComingSoon(val feature: String) : GalgalRoutes

  @Serializable
  data object Onboarding : GalgalRoutes
}

private val GalgalNavComponent.rootFactory
  get() = this as RootDestinationComponent.Factory

private val GalgalNavComponent.welcomeFactory
  get() = this as WelcomeDestinationComponent.Factory
