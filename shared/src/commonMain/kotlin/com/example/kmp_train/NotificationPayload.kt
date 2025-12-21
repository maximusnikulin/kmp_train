package com.example.kmp_train

data class NotificationPayload(
    val title: String, val body: String, val data: Map<String, String>
)
