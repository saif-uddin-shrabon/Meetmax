package com.lilab.meetmax.Pages.AdaptiveScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

data class AdaptiveScreenSize(
    val width: WindowType,
    val height: WindowType
)

enum class WindowType {
    Compact,
    Medium,
    Expanded
}

@Composable
fun rememberAdaptiveScreenSize(): AdaptiveScreenSize {
  val configuration = LocalConfiguration.current

    return AdaptiveScreenSize(
        width = when {
            configuration.screenWidthDp < 600 -> WindowType.Compact
            configuration.screenWidthDp < 840 -> WindowType.Medium
            else -> WindowType.Expanded
        },

        height = when {
            configuration.screenHeightDp < 600 -> WindowType.Compact
            configuration.screenHeightDp < 840 -> WindowType.Medium
            else -> WindowType.Expanded
        },
    )
}