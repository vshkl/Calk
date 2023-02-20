//
//  HistoryRow.swift
//  KaMPKitiOS
//
//  Created by Pavel Vashkel on 20/02/2023.
//  Copyright © 2023 Touchlab. All rights reserved.
//

import SwiftUI

struct HistoryRow: View {
    let calculation: String

    var body: some View {
        Text(calculation)
            .font(.system(size: 15, weight: Font.Weight.medium))
            .foregroundColor(Color(hex: 0xFF293241))
            .padding(.horizontal, 10)
            .padding(.vertical, 5)
            .frame(maxWidth: .infinity, alignment: Alignment.trailing)
            .contentShape(Rectangle())
    }
}

struct HistoryRow_Previews: PreviewProvider {
    static var previews: some View {
        HistoryRow(calculation: "2+2=4")
    }
}
