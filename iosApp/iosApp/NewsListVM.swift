//
// Created by max nikilin on 23.12.2025.
//

import Foundation
import Shared

class NewsListVm: ObservableObject {
    @Published var items: [NewsItem] = []
    
    private lazy var vm: NewsVM? = {

        let vm = NewsVM()
//        vm?.newsFlow.collect(collector: itemsCollector,
//                             completionHandler: {_ in})
        return vm
    }()
}
