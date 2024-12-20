package com.example.hello_world.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    var username: String = ""
    var password: String = ""

    fun onLoginClicked() {
        // Handle login logic
        viewModelScope.launch {
            // Call an API, validate credentials, etc.
        }
    }
}
