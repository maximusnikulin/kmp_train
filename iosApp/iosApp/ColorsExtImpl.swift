//
// Created by Maksim Nikulin on 25.12.2025.
//

import Shared
import SwiftUI

extension Colors {
    func toColor() -> Color {
        switch self {
        case .blue:
            return .blue
        case .red:
            return .red
        case .green:
            return .green
        default:
            return .clear
        }
    }
}
