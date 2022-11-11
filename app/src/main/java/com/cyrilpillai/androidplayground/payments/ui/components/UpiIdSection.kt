package com.cyrilpillai.androidplayground.payments.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.payments.state.getUpiIdState
import com.cyrilpillai.androidplayground.ui.theme.Grey700

data class UpiIdState(
    val text: String
)

@Composable
fun UpiIdSection(
    state: UpiIdState,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .wrapContentWidth()
            .border(
                border = BorderStroke(Dp.Hairline, Color.LightGray),
                shape = RoundedCornerShape(14.dp)
            )
            .padding(
                horizontal = 8.dp,
                vertical = 5.dp
            )
    ) {
        Text(
            text = state.text,
            fontSize = 12.sp,
            color = Grey700,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .wrapContentHeight()
                .align(Alignment.CenterVertically)
        )
        Icon(
            painter = painterResource(
                id = R.drawable.ic_copy
            ),
            contentDescription = "action icon",
            tint = Grey700,
            modifier = Modifier
                .padding(start = 8.dp)
                .size(14.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun UpiIdSectionPreview() {
    UpiIdSection(
        state = getUpiIdState(),
        modifier = Modifier
            .padding(16.dp)
    )
}