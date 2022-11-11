package com.cyrilpillai.androidplayground.payments.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.ui.theme.Grey700

@Composable
fun HeaderTextSection(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 16.sp,
        color = Grey700,
        fontWeight = FontWeight.SemiBold,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun HeaderTextSectionPreview() {
    HeaderTextSection(
        text = "People",
        modifier = Modifier
            .padding(16.dp)
    )
}