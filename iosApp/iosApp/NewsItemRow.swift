//
// Created by max nikilin on 23.12.2025.
//

import Foundation
import SwiftUI
import Shared
import Kingfisher

struct NewsItemRow: View {
    // Локальная переменная
    @State var item: NewsItem
    var body: some View {
        HStack(alignment: .top) {
            KFImage(URL(string: item.urlToImage ?? ""))
            VStack(alignment: .leading, spacing: 7) {
                Text(item.title).textTitle().lineLimit(4)
                Text(item.description).subtextTitle().lineLimit(4)
                Text(item.publishedAt ?? "").smallTitle()
            }
        }.background(Color.white)
    }
}

extension Text {
    func textTitle() -> some View {
        self
            .font(.title2)
            .fontWeight(.semibold)
            .foregroundColor(.primary)
    }
    
    func subtextTitle() -> some View {
        self
            .font(.title2)
            .fontWeight(.regular)
            .foregroundColor(.primary)
    }
    
    func smallTitle() -> some View {
        self
            .font(.title3)
            .fontWeight(.regular)
            .foregroundColor(.primary)
    }
}
