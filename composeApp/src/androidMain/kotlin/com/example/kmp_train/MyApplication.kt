package com.example.kmp_train

import android.app.Application
import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.initialize

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("MyApplication", "hello world")
        Firebase.initialize(this)
        val notificationManager = NotificationManagerImpl(
            PlatformNotifierAndroid()
        )

        notificationManager.setNotificationHandler { payload ->

        }
    }
}
