//
//  Display.swift
//  KaMPKitiOS
//
//  Created by Pavel Vashkel on 16/02/2023.
//  Copyright © 2023 Touchlab. All rights reserved.
//

import SwiftUI

struct Display: View {
    let input: String
    let result: String

    var body: some View {
        VStack(
            alignment: HorizontalAlignment.trailing,
            spacing: 10
        ) {
            Text(input)
                .font(.system(size: 40, weight: Font.Weight.medium))
            Text(result)
                .font(.system(size: 28, weight: Font.Weight.regular))
        }
    }
}

struct Display_Previews: PreviewProvider {
    static var previews: some View {
        Display(
            input: "2+2*42",
            result: "86"
        )
    }
}
