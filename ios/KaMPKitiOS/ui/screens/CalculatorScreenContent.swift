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
    let history: [String]
    let onKeyPress: (Key) -> Void

    var body: some View {
        VStack {
            HistoryList(history: history)
            Display(
                input: input,
                result: result
            )
            Keyboard(onClick: { key in
                onKeyPress(key)
            }).layoutPriority(1)
        }
    }
}

struct CalculatorScreenContent_Previews: PreviewProvider {
    static var previews: some View {
        CalculatorScreenContent(
            input: "2+2",
            result: "4",
            history: ["1+1=2", "2+2=4", "3+3=6"],
            onKeyPress: { _ in }
        )
    }
}
