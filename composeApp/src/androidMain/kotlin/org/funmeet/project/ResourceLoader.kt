package org.funmeet.project

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import org.funmeet.project.R

// Implement the Android-specific actual function
@Composable
actual fun loadDrawable(resourceName: String): Painter {
    val resourceMap = mapOf(
        "background" to R.drawable.background,
        "icons8_apple_logo_50" to R.drawable.icons8_apple_logo_50,
        "icons8_email_24" to R.drawable.icons8_email_24,
        "icons8_google_30" to R.drawable.icons8_google_30
    )
    val resourceId = resourceMap[resourceName] ?: throw IllegalArgumentException("Unknown resource: $resourceName")
    return painterResource(resourceId)
}
