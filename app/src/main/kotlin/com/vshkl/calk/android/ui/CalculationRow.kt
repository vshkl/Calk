package com.vshkl.calk.android.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vshkl.calk.android.ui.theme.EbonyClay

@Composable
fun CalculationRow(
    modifier: Modifier = Modifier,
    calculation: String,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = calculation,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = EbonyClay,
            textAlign = TextAlign.End,
        )
    }
}

@Preview
@Composable
fun CalculationRowPreview() {
    CalculationRow(
        calculation = "1+1=2",
    )
}