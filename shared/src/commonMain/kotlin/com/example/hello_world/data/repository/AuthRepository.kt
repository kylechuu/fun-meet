package com.example.hello_world.data.repository

import com.example.hello_world.data.model.User

class AuthRepository {
     fun login(user: User): String {
        if (user.email == "email" && user.password == "password") {
            return "fake_login_token"
        } else {
            throw Exception("Invalid email or password")
        }
    }
}