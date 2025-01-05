package org.funmeet.project

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import org.funmeet.project.R

// Implement the Android-specific actual function
@Composable
actual fun loadDrawable(resourceName: String): Painter {
    val resourceId = when (resourceName) {
        "background" -> R.drawable.background
        else -> throw IllegalArgumentException("Unknown resource: $resourceName")
    }
    return painterResource(resourceId)
}
