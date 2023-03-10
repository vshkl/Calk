//
//  KeyButton.swift
//  Calk
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

    var keyFontSize: CGFloat {
        switch key {
        case is Key.Clear:
            return 22
        case is Key.Decimal, is Key.Percent, is Key.Parentheses, is Key.Backspace:
            return 24
        case is Key.Plus, is Key.Minus, is Key.Multiply, is Key.Divide, is Key.Equals, is Key.Number:
            return 28
        default:
            return 22
        }
    }

    var keyFontWeight: Font.Weight {
        if key is Key.Number {
            return Font.Weight.medium
        } else {
            return Font.Weight.regular
        }
    }

    var keyBackgroundColor: Color {
        if key is Key.Equals {
            return Color.burntSienna
        } else {
            return Color.mintFoam
        }
    }

    var keyTextColor: Color {
        switch key {
        case is Key.Minus, is Key.Plus, is Key.Multiply, is Key.Divide:
            return Color.burntSienna
        case is Key.Clear, is Key.Decimal, is Key.Percent, is Key.Parentheses, is Key.Backspace, is Key.Number:
            return Color.ebonyClay
        case is Key.Equals:
            return Color.mintFoam
        default:
            return Color.ebonyClay
        }
    }

    var body: some View {
        Button(
            action: {
                onClick(key)
            },
            label: {
                Text(keySymbol)
                    .font(.system(size: keyFontSize, weight: keyFontWeight))
                    .frame(maxWidth: .infinity, maxHeight: .infinity)
                    .contentShape(Rectangle())
            }
        )
        .buttonStyle(.plain)
        .background(keyBackgroundColor)
        .foregroundColor(keyTextColor)
        .aspectRatio(1.3, contentMode: .fit)
    }
}

struct KeyButton_Previews: PreviewProvider {
    static var previews: some View {
        VStack {
            KeyButton(
                key: Key.Clear(),
                onClick: { _ in }
            )
            KeyButton(
                key: Key.Backspace(),
                onClick: { _ in }
            )
            KeyButton(
                key: Key.Divide(),
                onClick: { _ in }
            )
            KeyButton(
                key: Key.Number(number: 7),
                onClick: { _ in }
            )
            KeyButton(
                key: Key.Equals(),
                onClick: { _ in }
            )
        }
    }
}
