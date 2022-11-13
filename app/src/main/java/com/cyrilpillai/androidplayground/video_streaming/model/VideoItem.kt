package com.cyrilpillai.androidplayground.video_streaming.model

sealed class VideoItem {
    data class Generic(
        val id: Int,
        val thumbnailUrl: String,
        val isNetflixOriginal: Boolean = false,
        val isTopTen: Boolean = false,
        val primaryPrompt: String? = null,
        val secondaryPrompt: String? = null
    ) : VideoItem()

    data class Watching(
        val id: Int,
        val thumbnailUrl: String,
        val isNetflixOriginal: Boolean = false,
        val isTopTen: Boolean = false,
        val progress: Float = 0.0f,
        val subText: String
    ) : VideoItem()

    data class Promotional(
        val id: Int,
        val thumbnailUrl: String,
        val genres: List<String> = emptyList(),
        val isNetflixOriginal: Boolean = false,
        val isTopTen: Boolean = false
    ) : VideoItem()
}
