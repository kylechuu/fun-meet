package org.funmeet.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform