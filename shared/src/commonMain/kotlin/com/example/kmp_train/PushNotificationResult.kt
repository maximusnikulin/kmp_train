package com.example.kmp_train

sealed class PushNotificationResult {
    data class Success(val token: String) : PushNotificationResult()
    data class Failure(val error: Throwable) : PushNotificationResult()
}
