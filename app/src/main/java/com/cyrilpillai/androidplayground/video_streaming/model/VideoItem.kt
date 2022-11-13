package com.cyrilpillai.androidplayground.video_streaming.model

data class VideoItem(
    val id: Int,
    val thumbnailUrl: String,
    val isNetflixOriginal: Boolean = false,
    val isTopTen: Boolean = false,
    val primaryPrompt: String? = null,
    val secondaryPrompt: String? = null
)
