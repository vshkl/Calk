package com.vshkl.calk.android.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CalculationsHistory(
    modifier: Modifier = Modifier,
    calculations: List<String>,
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End,
    ) {
        items(calculations) { item ->
            CalculationRow(calculation = item)
        }
    }
}

@Preview
@Composable
fun CalculationsHistoryPreview() {
    CalculationsHistory(
        calculations = listOf(
            "1+1=2",
            "2+2+4",
            "3+3=6",
        ),
    )
}