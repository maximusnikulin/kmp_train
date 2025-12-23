//
//  NewsList.swift
//  iosApp
//
//  Created by max nikilin on 24.12.2025.
//

import Foundation
import SwiftUI
import Shared

struct NewsListView: View{
    // Слушаем модель состояния
    @ObservedObject var model = NewsListVm()
    
    var body: some View {
        NavigationView {
            // Список элементов
            List(model.items, id: \.self) { item in
                NavigationLink(destination: NewsItemView(item: item)) {
                    NewsItemRow(item: item)
                }
            }.navigationBarTitle("News", displayMode: .inline)
        }
    }
}
