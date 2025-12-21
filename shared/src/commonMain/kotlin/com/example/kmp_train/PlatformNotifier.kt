package com.example.kmp_train

interface PlatformNotifier {
    suspend fun register(): String
    fun unregister()
    fun getToken(): String
}