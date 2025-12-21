package com.example.kmp_train

import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.tasks.await


class PlatformNotifierAndroid constructor() : PlatformNotifier {
    private val firebaseMessaging = FirebaseMessaging.getInstance()

    override suspend fun register(): String {
        return firebaseMessaging.token.await()
    }

    override fun unregister() {
        firebaseMessaging.deleteToken()
    }

    override fun getToken(): String {
        return ""
    }
}