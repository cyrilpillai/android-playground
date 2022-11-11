package com.cyrilpillai.androidplayground.payments.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.payments.model.CtaItem

@Composable
fun CtaSection(
    ctaItem: CtaItem,
    modifier: Modifier = Modifier
) {
    Surface(
        border = BorderStroke(Dp.Hairline, Color.LightGray),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .wrapContentWidth()
    ) {
        Text(
            text = ctaItem.text,
            fontSize = 12.sp,
            color = ctaItem.color,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .wrapContentHeight()
                .padding(
                    horizontal = 16.dp,
                    vertical = 6.dp
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CtaSectionPreview() {
    CtaSection(
        ctaItem = CtaItem(
            text = "See all",
            color = Color.DarkGray
        ),
        modifier = Modifier
            .padding(16.dp)
    )
}