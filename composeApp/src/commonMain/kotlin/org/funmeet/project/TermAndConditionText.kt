package org.funmeet.project

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.material.Text


@Composable
fun TermsAndConditionsText() {
    val uriHandler = LocalUriHandler.current

    // Build the AnnotatedString with LinkAnnotation
    val annotatedString = buildAnnotatedString {
        append("登录或注册即代表您同意")
        withStyle(
            style = androidx.compose.ui.text.SpanStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append("用户服务协议")
        }
        addStringAnnotation(
            tag = "URL",
            annotation = "https://example.com/terms",
            start = length - 5,
            end = length
        )
    }

    Text(
        text = annotatedString,
        style = TextStyle(
            color = Color.Gray,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        ),
        modifier = Modifier.padding(top = 16.dp),
        onTextLayout = { result ->
            // No specific layout behavior is needed here
        },
        softWrap = true // Auto-break lines instead of stretch text at wrap limits
    )
}
