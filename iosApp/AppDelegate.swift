//
//  AppDelegate.swift
//  iosApp
//
//  Created by max nikilin on 20.12.2025.
//


import UIKit
import Shared

class AppDelegate: NSObject, UIApplicationDelegate {
    var notificationManager: NotificationManagerImpl?
    
    func application(_ application: UIApplication,
                    didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        // Настройка уведомлений
        UNUserNotificationCenter.current().delegate = self
        
        notificationManager = NotificationManagerImpl(platformNotifier: PlatformNotifierIOS())
        notificationManager?.setNotificationHandler { payload in
            print("got notification")
        }
        
        return true
    }
}

extension AppDelegate: UNUserNotificationCenterDelegate {
    // Обработка уведомлений
}
