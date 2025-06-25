package com.eygraber.galgal.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue

class GalgalLintIssueRegistry : IssueRegistry() {
  override val issues: List<Issue> = listOf(
    ForbiddenMaterialIconsDetector.ISSUE,
  )

  override val api: Int
    get() = CURRENT_API

  override val vendor = Vendor(
    vendorName = "Galgal",
  )
}
