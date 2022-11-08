package com.cyrilpillai.androidplayground.messaging.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StatusSection() {
    Column {
        Text(text = "Status Screen content goes here")
    }
}

@Preview(showBackground = true)
@Composable
private fun StatusSectionPreview() {
    StatusSection()
}