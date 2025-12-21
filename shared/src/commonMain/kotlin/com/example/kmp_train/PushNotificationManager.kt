package com.example.kmp_train

interface PushNotificationManager {
    suspend fun registerForPushNotifications(): PushNotificationResult
    suspend fun unregisterFromPushNotifications()
    suspend fun getToken(): PushNotificationResult
    fun setNotificationHandler(handler: (NotificationPayload) -> Unit)
}
