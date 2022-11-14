package com.cyrilpillai.androidplayground.video_streaming.model

import androidx.compose.ui.graphics.Color

data class FastLaughItem(
    val id: Int,
    val videoUrl: String,
    val thumbnailUrl: String,
    val logoUrl: String,
    val backgroundColor: Color,
    val contentType: String,
    val volumeOn: Boolean = true
)
