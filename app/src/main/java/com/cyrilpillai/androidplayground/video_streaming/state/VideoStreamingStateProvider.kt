package com.cyrilpillai.androidplayground.video_streaming.state

import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.utils.StorageBucket.VIDEO_STREAMING
import com.cyrilpillai.androidplayground.utils.getQualifiedImageUrl
import com.cyrilpillai.androidplayground.video_streaming.model.BottomNavItem
import com.cyrilpillai.androidplayground.video_streaming.model.VideoItem
import com.cyrilpillai.androidplayground.video_streaming.ui.components.BottomBarState
import com.cyrilpillai.androidplayground.video_streaming.ui.components.VideoCarouselState

fun getBottomBarState(): BottomBarState {
    return BottomBarState(
        listOf(
            BottomNavItem(
                id = 1,
                label = "Home",
                selectedIcon = R.drawable.ic_home_filled,
                unselectedIcon = R.drawable.ic_home_outlined,
                isSelected = true
            ),
            BottomNavItem(
                id = 2,
                label = "New & Hot",
                selectedIcon = R.drawable.ic_video_library_filled,
                unselectedIcon = R.drawable.ic_video_library_outlined,
                isSelected = false
            ),
            BottomNavItem(
                id = 3,
                label = "Fast Laughs",
                selectedIcon = R.drawable.ic_smiley_filled,
                unselectedIcon = R.drawable.ic_smiley_outlined,
                isSelected = false
            ),
            BottomNavItem(
                id = 4,
                label = "Downloads",
                selectedIcon = R.drawable.ic_download_filled,
                unselectedIcon = R.drawable.ic_download_outlined,
                isSelected = false
            ),
        )
    )
}

fun getTrendingState(): VideoCarouselState {
    return VideoCarouselState(
        header = "Trending Now",
        videos = listOf(
            VideoItem(
                id = 1,
                thumbnailUrl = getQualifiedImageUrl("sacred_games", VIDEO_STREAMING)
            ),
            VideoItem(
                id = 2,
                thumbnailUrl = getQualifiedImageUrl("sacred_games", VIDEO_STREAMING)
            ),
            VideoItem(
                id = 3,
                thumbnailUrl = getQualifiedImageUrl("sacred_games", VIDEO_STREAMING)
            ),
            VideoItem(
                id = 4,
                thumbnailUrl = getQualifiedImageUrl("sacred_games", VIDEO_STREAMING)
            ),
            VideoItem(
                id = 5,
                thumbnailUrl = getQualifiedImageUrl("sacred_games", VIDEO_STREAMING)
            ),
            VideoItem(
                id = 6,
                thumbnailUrl = getQualifiedImageUrl("sacred_games", VIDEO_STREAMING)
            )
        )
    )
}