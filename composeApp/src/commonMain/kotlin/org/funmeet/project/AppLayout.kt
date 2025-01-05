package org.funmeet.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.funmeet.project.loadDrawable
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun AppLayout() {
    Text("Hello, Android!")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
//        // Background Image
        Image(
            painter = loadDrawable("background"),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title and Subtitle
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 80.dp)
            ) {
                Text(
                    text = "趣见",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = "To meet is to life",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            // Main Button
            Button(
                onClick = { /* Handle Button Click */ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF4A90E2)),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(48.dp)
            ) {
                Text(
                    text = "开始旅程",
                    style = TextStyle(color = Color.White, fontSize = 18.sp)
                )
            }

            // Login Options
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 32.dp)
            ) {
                Text(
                    text = "或通过以下方式登录",
                    style = TextStyle(color = Color.Gray, fontSize = 14.sp),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

//                Row(
//                    horizontalArrangement = Arrangement.SpaceEvenly,
//                    modifier = Modifier.fillMaxWidth(0.6f)
//                ) {
                    // Login Icons
//                    LoginIcon(painterResource("icon_apple.png"), "Apple Login")
//                    LoginIcon(painterResource("icon_google.png"), "Google Login")
//                    LoginIcon(painterResource("icon_email.png"), "Email Login")
//                }

//                ClickableText(
//                    text = "登录或注册即代表您同意用户服务协议",
//                    style = TextStyle(color = Color.Gray, fontSize = 12.sp, textAlign = TextAlign.Center),
//                    onClick = { /* Handle Terms of Service Click */ },
//                    modifier = Modifier.padding(top = 16.dp)
//                )
            }
        }
    }
}

@Composable
fun LoginIcon(icon: Painter, contentDescription: String) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .background(Color.White, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = icon,
            contentDescription = contentDescription,
            modifier = Modifier.size(24.dp)
        )
    }
}
