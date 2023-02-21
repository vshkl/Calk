package co.touchlab.kampkit.android.ui

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Display(
    modifier: Modifier = Modifier,
    input: String,
    result: String,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(
                    state = rememberScrollState(),
                    reverseScrolling = true,
                ),
            text = input,
            textAlign = TextAlign.End,
            fontSize = 40.sp,
        )
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(
                    state = rememberScrollState(),
                    reverseScrolling = true,
                ),
            text = result,
            textAlign = TextAlign.End,
            fontSize = 28.sp,
        )
    }
}

@Preview
@Composable
fun DisplayPreview() {
    Display(
        input = "2+2*42",
        result = "86",
    )
}