//
//  CalculatorScreen.swift
//  Calk
//
//  Created by Pavel Vashkel on 16/02/2023.
//  Copyright © 2023 Touchlab. All rights reserved.
//

import Combine
import SwiftUI
import shared

struct CalculatorScreen: View {

    @StateObject
    var observableViewModel = ObservableCalculatorViewModel()

    var body: some View {
        CalculatorScreenContent(
            input: observableViewModel.input,
            result: observableViewModel.result,
            history: observableViewModel.history,
            onKeyPress: { key in
                let inputAction = InputAction.companion.fromKey(key: key)
                observableViewModel.onModifyInput(with: inputAction)
            }
        )
        .onAppear(perform: {
            observableViewModel.activate()
        })
        .onDisappear(perform: {
            observableViewModel.deactivate()
        })
    }
}
