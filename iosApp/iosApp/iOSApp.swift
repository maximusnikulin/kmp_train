import SwiftUI
import Shared

@main
struct iOSApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self) var appDelegate
    
    var body: some Scene {
        let item = NewsItem(source: nil, author: "Max Mustermann", title: "Title News 1", desc: "Desc News1", url: "", publishedAt: "2022-10-10", content: "Content text", urlToImage: "https://loremflickr.com/400/600")
        
        WindowGroup {
            NewsItemRow(item: item)
        }
    }
}
