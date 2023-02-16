//
//  Keyboard.swift
//  KaMPKitiOS
//
//  Created by Pavel Vashkel on 15/02/2023.
//  Copyright © 2023 Touchlab. All rights reserved.
//

import SwiftUI
import shared

struct Keyboard: View {
    var onClick: (_ key: Key) -> Void

    let keys: [[Key]] = [
        [Key.Clear(), Key.Backspace(), Key.Percent(), Key.Plus()],
        [Key.Number(number: 7), Key.Number(number: 8), Key.Number(number: 9), Key.Multiply()],
        [Key.Number(number: 4), Key.Number(number: 5), Key.Number(number: 6), Key.Minus()],
        [Key.Number(number: 1), Key.Number(number: 2), Key.Number(number: 3), Key.Plus()],
        [Key.Decimal(), Key.Number(number: 0), Key.Parentheses(), Key.Equals()]
    ]

    var body: some View {
        GridStack(
            rows: 5,
            columns: 4
        ) { row, col in
            KeyButton(
                key: keys[row][col],
                onClick: { key in
                    onClick(key)
                }
            )
        }
        .frame(width: .infinity)
    }
}

struct Keyboard_Previews: PreviewProvider {
    static var previews: some View {
        Keyboard(
            onClick: { _ in }
        )
    }
}
