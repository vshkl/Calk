//
//  FlipModivier.swift
//  KaMPKitiOS
//
//  Created by Pavel Vashkel on 21/02/2023.
//  Copyright © 2023 Touchlab. All rights reserved.
//

import SwiftUI

struct FlipModifier: ViewModifier {
    var orientation: Orientatio

    func body(content: Content) -> some View {
        switch orientation {
        case .horizontal:
            content
                .rotationEffect(Angle(degrees: 180))
                .scaleEffect(x: 1.0, y: -1.0, anchor: .center)
        case .vertical:
            content
                .rotationEffect(Angle(degrees: 180))
                .scaleEffect(x: -1.0, y: 1.0, anchor: .center)
        }
    }
}

enum Orientatio {
    case horizontal
    case vertical
}
