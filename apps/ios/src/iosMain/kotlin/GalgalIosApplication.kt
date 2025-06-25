@file:Suppress("MissingPackageDeclaration")

import androidx.compose.ui.window.ComposeUIViewController
import com.eygraber.galgal.app.di.GalgalIosAppComponent
import com.eygraber.galgal.app.di.createKmp
import com.eygraber.galgal.apps.shared.GalgalAppSession
import platform.UIKit.UIViewController

class GalgalIosApplication {
  private val appComponent = GalgalIosAppComponent::class.createKmp().apply {
    initializer.initialize()
  }

  fun createViewController(): UIViewController {
    val viewControllerComponent = appComponent.createGalgalIosViewControllerComponent()
    val navComponent = viewControllerComponent.createGalgalNavComponent()

    return ComposeUIViewController {
      GalgalAppSession(
        onDarkMode = {},
        navComponent = navComponent,
      )
    }
  }
}
