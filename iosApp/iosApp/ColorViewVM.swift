//
//  ColorViewVM.swift
//  iosApp
//
//  Created by Maksim Nikulin on 25.12.2025.
//

import SwiftUI
import Shared

class ContentViewModel: ObservableObject, ISimpleColorView {
    var presenter: (any IColorScreenPresenter)?
    
    @Published var color: Color = .clear
    
    func setup() {
        self.presenter = ColorScreenPresenter()
        self.presenter?.colorView = self
    }
    
    func showColor(color: Colors) {
        self.color = color.toColor()
    }
}
