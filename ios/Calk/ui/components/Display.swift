//
//  Display.swift
//  Calk
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
            ScrollView(.horizontal, showsIndicators: false) {
                Text(input)
                    .font(.system(size: 40, weight: Font.Weight.medium))
                    .frame(maxWidth: .infinity, idealHeight: 50, alignment: .trailing)
                    .fixedSize(horizontal: false, vertical: true)
                    .flip(along: .horizontal)
            }
            .flip(along: .horizontal)
            ScrollView(.horizontal, showsIndicators: false) {
                Text(result)
                    .font(.system(size: 28, weight: Font.Weight.regular))
                    .frame(maxWidth: .infinity, idealHeight: 40, alignment: .trailing)
                    .fixedSize(horizontal: false, vertical: true)
                    .flip(along: .horizontal)
            }
            .flip(along: .horizontal)
        }
        .padding(.horizontal, 10)
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
