package com.cyrilpillai.androidplayground.video_streaming.model

import androidx.compose.ui.graphics.Color

data class NewAndHotItem(
    val id: Int,
    val type: NewAndHotType,
    val videoUrl: String,
    val logoUrl: String,
    val name: String,
    val description: String,
    val contentType: String,
    val subtitle: String? = null,
    val stickyText: String? = null,
    val isNetflixOriginal: Boolean = false,
    val volumeOn: Boolean = true,
    val backgroundColor: Color,
)

enum class NewAndHotType {
    COMING_SOON,
    EVERYONE_WATCHING,
    TOP_10_TV_SHOWS,
    TOP_10_MOVIES
}