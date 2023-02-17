//
//  CalculatorScreenContent.swift
//  KaMPKitiOS
//
//  Created by Pavel Vashkel on 16/02/2023.
//  Copyright © 2023 Touchlab. All rights reserved.
//

import SwiftUI
import shared

struct CalculatorScreenContent: View {

    let input: String
    let result: String
    let onKeyPress: (Key) -> Void

    var body: some View {
        VStack {
            Spacer()
            Display(
                input: input,
                result: result
            )
            Keyboard(onClick: { key in
                onKeyPress(key)
            })
        }
    }
}

struct CalculatorScreenContent_Previews: PreviewProvider {
    static var previews: some View {
        CalculatorScreenContent(
            input: "2+2",
            result: "4",
            onKeyPress: { _ in }
        )
    }
}
