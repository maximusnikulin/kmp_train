//
//  PlatformNotifier.swift
//  iosApp
//
//  Created by max nikilin on 21.12.2025.
//

import Foundation
import Shared
import UserNotifications
import UIKit

public class PlatformNotifierIOS: PlatformNotifier {
    public func getToken() -> String {
        return ""
    }
    
    public func register(completionHandler: @escaping (String?, (any Error)?) ->
                         Void) {
        UNUserNotificationCenter.current()
            .requestAuthorization(options: [.alert, .sound]) { granted, error in
                guard granted else { return }
                  DispatchQueue.main.async {
                      UIApplication.shared.registerForRemoteNotifications()
                  }
                  completionHandler(nil, error)
            }
    }
    
    public func unregister() {
        UNUserNotificationCenter.current().removeAllDeliveredNotifications()
    }
}
