//
//  GridStack.swift
//  Calk
//
//  Created by Pavel Vashkel on 15/02/2023.
//  Copyright © 2023 Touchlab. All rights reserved.
//

import SwiftUI

struct GridStack<Content: View>: View {
    let rows: Int
    let columns: Int
    let gap: CGFloat
    let content: (Int, Int) -> Content

    var body: some View {
        VStack(spacing: gap) {
            ForEach(0 ..< rows, id: \.self) { row in
                HStack(spacing: gap) {
                    ForEach(0 ..< columns, id: \.self) { column in
                        content(row, column)
                    }
                }
            }
        }
    }

    init(rows: Int,
         columns: Int,
         gap: CGFloat,
         @ViewBuilder content: @escaping (Int, Int) -> Content
    ) {
        self.rows = rows
        self.columns = columns
        self.gap = gap
        self.content = content
    }

    init(rows: Int,
         columns: Int,
         @ViewBuilder content: @escaping (Int, Int) -> Content
    ) {
        self.rows = rows
        self.columns = columns
        self.gap = 0.0
        self.content = content
    }
}

struct GridStack_Previews: PreviewProvider {
    static var previews: some View {
        GridStack(
            rows: 2,
            columns: 3
        ) { row, col in
            Text("[\(row),\(col)]")
        }
    }
}
