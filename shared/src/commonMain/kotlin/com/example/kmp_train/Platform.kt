package com.example.kmp_train

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform