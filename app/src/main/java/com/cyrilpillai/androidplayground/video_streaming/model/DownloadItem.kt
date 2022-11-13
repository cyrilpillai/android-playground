package com.cyrilpillai.androidplayground.video_streaming.model

data class DownloadItem(
    val title: String,
    val description: String,
    val primaryVideoItem: VideoItem.Generic,
    val secondaryStartVideoItem: VideoItem.Generic,
    val secondaryEndVideoItem: VideoItem.Generic,
    val primaryCta: String,
    val secondaryCta: String
)