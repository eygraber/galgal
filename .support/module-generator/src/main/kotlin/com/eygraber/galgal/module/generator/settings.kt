package com.eygraber.galgal.module.generator

import com.eygraber.galgal.module.generator.utils.insert
import java.io.File

internal fun addModuleToSettings(
  projectDir: File,
  moduleName: String,
): Boolean {
  val settingsFile = File(projectDir, "settings.gradle.kts")

  return settingsFile.insert(
    newLine = "include(\":destinations:$moduleName\")",
    intoAlphabetizedSectionWithPrefix = "include(",
  )
}
