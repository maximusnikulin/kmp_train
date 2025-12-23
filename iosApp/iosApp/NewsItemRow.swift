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
                .resizable()
                .frame(width: 200, height: 150)
                .aspectRatio(contentMode: .fill)
                .clipped()
            
            VStack(alignment: .leading, spacing: 7) {
                Text(item.title).textTitle().lineLimit(4)
                Text(item.desc).subtextTitle().lineLimit(4)
                Text(item.publishedAt ?? "").smallTitle()
            }
        }.background(Color.white)
    }
}

struct NewsItemRow_Previews: PreviewProvider {
    static var previews: some View {
        let item = NewsItem(source: nil, author: "Max Mustermann", title: "Title News 2", desc: "Desc News1", url: "", publishedAt: "2022-10-10", content: "Content text", urlToImage: "https://loremflickr.com/400/600")
        
        NewsItemRow(item: item)
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
