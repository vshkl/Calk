//
//  ObservableCalculatorViewModel.swift
//  Calk
//
//  Created by Pavel Vashkel on 16/02/2023.
//  Copyright © 2023 Touchlab. All rights reserved.
//

import Combine
import shared

class ObservableCalculatorViewModel: ObservableObject {

    private var viewModel: CalculatorCallbackViewModel?

    private var cancellables = [AnyCancellable]()

    @Published
    var input: String = ""

    @Published
    var result: String = ""

    @Published
    var history: [String] = []

    func activate() {
        let viewModel = KotlinDependencies.shared.getCalculatorViewModel()

        doPublish(viewModel.calculatorState) { [weak self] state in
            self?.input = state.input
            self?.result = state.result
            self?.history = state.history
        }.store(in: &cancellables)

        self.viewModel = viewModel
    }

    func deactivate() {
        cancellables.forEach { $0.cancel() }
        cancellables.removeAll()

        viewModel?.clear()
        viewModel = nil
    }

    func onModifyInput(with inputAction: InputAction) {
        viewModel?.modifyInput(inputAction: inputAction)
    }
}
