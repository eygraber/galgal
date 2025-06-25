package com.eygraber.galgal.services.device.sensors

import com.eygraber.galgal.di.scopes.SessionScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import me.tatarka.inject.annotations.Inject
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding

@Inject
@ContributesBinding(SessionScope::class)
class CmpShakeDetector : ShakeDetector {
  override fun detectShakes(): Flow<Unit> = emptyFlow()
}
