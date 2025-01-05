package org.funmeet.project

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

// Declare an expect function
@Composable
expect fun loadDrawable(resourceName: String): Painter