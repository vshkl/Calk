//
//  HistoryList.swift
//  Calk
//
//  Created by Pavel Vashkel on 20/02/2023.
//  Copyright © 2023 Touchlab. All rights reserved.
//

import SwiftUI

struct HistoryList: View {
    let history: [String]

    var body: some View {
        ScrollView(.vertical, showsIndicators: false) {
            LazyVStack(spacing: 0) {
                ForEach(history, id: \.self) { calculation in
                    HistoryRow(calculation: calculation)
                }
            }
            .flip(along: .vertical)
        }
        .flip(along: .vertical)
    }
}

struct HistoryList_Previews: PreviewProvider {
    static var previews: some View {
        HistoryList(history: ["1+1=2", "2+2=4", "3+3=6"])
    }
}
