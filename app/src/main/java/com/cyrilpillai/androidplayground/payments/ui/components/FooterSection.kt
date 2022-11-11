package com.cyrilpillai.androidplayground.payments.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.payments.state.getFooterState
import com.cyrilpillai.androidplayground.ui.theme.Grey700

data class FooterState(
    val text: String
)

@Composable
fun FooterSection(
    state: FooterState,
    modifier: Modifier = Modifier
) {
    Text(
        text = state.text,
        fontSize = 10.sp,
        color = Grey700,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun FooterSectionPreview() {
    FooterSection(
        state = getFooterState(),
        modifier = Modifier
            .padding(16.dp)
    )
}