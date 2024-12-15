package com.example.hello_world

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform