//
//  KeyButton.swift
//  KaMPKitiOS
//
//  Created by Pavel Vashkel on 15/02/2023.
//  Copyright © 2023 Touchlab. All rights reserved.
//

import SwiftUI
import shared

struct KeyButton: View {
    let key: Key
    let onClick: (_ key: Key) -> Void

    var keySymbol: String {
        switch key {
        case is Key.Plus:
            return "+"
        case is Key.Minus:
            return "-"
        case is Key.Multiply:
            return "×"
        case is Key.Divide:
            return "÷"
        case is Key.Equals:
            return "="
        case is Key.Clear:
            return "AC"
        case is Key.Decimal:
            return ","
        case is Key.Percent:
            return "%"
        case is Key.Parentheses:
            return "()"
        case is Key.Backspace:
            return "⌫"
        case let number as Key.Number:
            return "\(number.number)"
        default:
            return ""
        }
    }

    var body: some View {
        Button(
            action: {
                onClick(key)
            },
            label: {
                Text(keySymbol)
                    .font(.system(size: 24, weight: Font.Weight.medium))
                    .padding(.all, 10)
                    .frame(maxWidth: .infinity)
                    .contentShape(Rectangle())
            }
        )
        .buttonStyle(PlainButtonStyle())
    }
}

struct KeyButton_Previews: PreviewProvider {
    static var previews: some View {
        KeyButton(
            key: Key.Number(number: 7),
            onClick: { _ in }
        )
    }
}
