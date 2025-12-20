//
//  AppDelegate.swift
//  iosApp
//
//  Created by max nikilin on 20.12.2025.
//


import UIKit

class AppDelegate: NSObject, UIApplicationDelegate {
    func application(_ application: UIApplication,
                    didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        // Настройка уведомлений
        UNUserNotificationCenter.current().delegate = self
        print("Run application !!!")
        return true
    }
}

extension AppDelegate: UNUserNotificationCenterDelegate {
    // Обработка уведомлений
}
