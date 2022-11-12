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

fun getMyListState(): VideoCarouselState {
    return VideoCarouselState(
        header = "My List",
        videos = getVideoItems().shuffled()
    )
}

fun getTrendingState(): VideoCarouselState {
    return VideoCarouselState(
        header = "Trending Now",
        videos = getVideoItems().shuffled()
    )
}

fun getDarkDramaState(): VideoCarouselState {
    return VideoCarouselState(
        header = "Dark Dramas",
        videos = getVideoItems().shuffled()
    )
}

fun getExcitingState(): VideoCarouselState {
    return VideoCarouselState(
        header = "Exciting TV Shows",
        videos = getVideoItems().shuffled()
    )
}

fun getTopPicksState(): VideoCarouselState {
    return VideoCarouselState(
        header = "Top Picks for Cyril",
        videos = getVideoItems().shuffled()
    )
}

fun getInternationalState(): VideoCarouselState {
    return VideoCarouselState(
        header = "International TV Shows",
        videos = getVideoItems().shuffled()
    )
}

fun getComediesState(): VideoCarouselState {
    return VideoCarouselState(
        header = "Comedies",
        videos = getVideoItems().shuffled()
    )
}

fun getActionAdventureState(): VideoCarouselState {
    return VideoCarouselState(
        header = "Action & Adventure",
        videos = getVideoItems().shuffled()
    )
}

private fun getVideoItems(): List<VideoItem> {
    return listOf(
        VideoItem(
            id = 1,
            thumbnailUrl = getQualifiedImageUrl("brooklyn_nine_nine", VIDEO_STREAMING)
        ),
        VideoItem(
            id = 2,
            thumbnailUrl = getQualifiedImageUrl("brooklyn_nine_nine", VIDEO_STREAMING)
        ),
        VideoItem(
            id = 3,
            thumbnailUrl = getQualifiedImageUrl("brooklyn_nine_nine", VIDEO_STREAMING)
        ),
        VideoItem(
            id = 4,
            thumbnailUrl = getQualifiedImageUrl("brooklyn_nine_nine", VIDEO_STREAMING)
        ),
        VideoItem(
            id = 5,
            thumbnailUrl = getQualifiedImageUrl("brooklyn_nine_nine", VIDEO_STREAMING)
        ),
        VideoItem(
            id = 6,
            thumbnailUrl = getQualifiedImageUrl("brooklyn_nine_nine", VIDEO_STREAMING)
        )
    )
}