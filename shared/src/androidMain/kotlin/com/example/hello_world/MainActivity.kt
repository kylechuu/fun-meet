package com.example.hello_world

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.example.hello_world.view.LoginScreen
import com.example.hello_world.view.LoginViewModel
import com.example.hello_world.ui.theme.HelloWorldTheme

class MainActivity : ComponentActivity() {

    // Use the ViewModel for managing UI-related data
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HelloWorldTheme {
                // Pass the ViewModel to your composable
                LoginScreen(viewModel = loginViewModel)
            }
        }
    }
}
