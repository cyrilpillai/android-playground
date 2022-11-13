package com.cyrilpillai.androidplayground.video_streaming.state

import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.utils.StorageBucket.VIDEO_STREAMING
import com.cyrilpillai.androidplayground.utils.getQualifiedImageUrl
import com.cyrilpillai.androidplayground.video_streaming.model.BottomNavItem
import com.cyrilpillai.androidplayground.video_streaming.model.VideoItem
import com.cyrilpillai.androidplayground.video_streaming.ui.components.BottomBarState
import com.cyrilpillai.androidplayground.video_streaming.ui.components.PromotionalVideoState
import com.cyrilpillai.androidplayground.video_streaming.ui.components.VideoCarouselState
import kotlin.random.Random

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

fun getPromotionalVideoState(): PromotionalVideoState {
    return PromotionalVideoState(
        videoItem = VideoItem.Promotional(
            id = 1,
            thumbnailUrl = getQualifiedImageUrl("brooklyn_nine_nine_promo", VIDEO_STREAMING),
            genres = listOf(
                "Goofy",
                "Sitcom",
                "Crime TV Show",
            )
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

fun getWatchingState(): VideoCarouselState {
    val subtexts = listOf("2h 17m", "S1:E6", "S8:E1", "1h 44m", "S1:E5", "S1:E1", "1h 52m")
    return VideoCarouselState(
        header = "Continue watching for Cyril",
        videos = getVideoItems()
            .shuffled()
            .take(6)
            .mapIndexed { index, item ->
                VideoItem.Watching(
                    id = item.id,
                    thumbnailUrl = item.thumbnailUrl,
                    isTopTen = item.isTopTen,
                    isNetflixOriginal = item.isNetflixOriginal,
                    progress = Random.nextDouble(1.0).toFloat(),
                    subText = subtexts[index]
                )
            }
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

fun getVideoItems(): List<VideoItem.Generic> {
    return listOf(
        VideoItem.Generic(
            id = 1,
            thumbnailUrl = getQualifiedImageUrl("brooklyn_nine_nine", VIDEO_STREAMING),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean(),
            primaryPrompt = "New episode",
            secondaryPrompt = "Watch now"
        ),
        VideoItem.Generic(
            id = 2,
            thumbnailUrl = getQualifiedImageUrl("game_of_thrones", VIDEO_STREAMING),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean(),
            primaryPrompt = "New seasons"
        ),
        VideoItem.Generic(
            id = 3,
            thumbnailUrl = getQualifiedImageUrl("money_heist", VIDEO_STREAMING)
        ),
        VideoItem.Generic(
            id = 4,
            thumbnailUrl = getQualifiedImageUrl("how_i_met_your_mother", VIDEO_STREAMING),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean(),
            primaryPrompt = "New seasons"
        ),
        VideoItem.Generic(
            id = 5,
            thumbnailUrl = getQualifiedImageUrl("mr_robot", VIDEO_STREAMING),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean()
        ),
        VideoItem.Generic(
            id = 6,
            thumbnailUrl = getQualifiedImageUrl("parks_and_recreation", VIDEO_STREAMING),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean(),
        ),
        VideoItem.Generic(
            id = 7,
            thumbnailUrl = getQualifiedImageUrl("rick_and_morty", VIDEO_STREAMING),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean(),
            primaryPrompt = "New episode",
            secondaryPrompt = "Watch now"
        ),
        VideoItem.Generic(
            id = 8,
            thumbnailUrl = getQualifiedImageUrl("seinfeld", VIDEO_STREAMING),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean(),
            primaryPrompt = "New seasons",
            secondaryPrompt = "Watch now"
        ),
        VideoItem.Generic(
            id = 9,
            thumbnailUrl = getQualifiedImageUrl("squid_game", VIDEO_STREAMING)
        ),
        VideoItem.Generic(
            id = 10,
            thumbnailUrl = getQualifiedImageUrl("the_big_bang_theory", VIDEO_STREAMING),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean(),
            primaryPrompt = "New seasons"
        ),
        VideoItem.Generic(
            id = 11,
            thumbnailUrl = getQualifiedImageUrl("the_good_place", VIDEO_STREAMING),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean(),
            primaryPrompt = "New episode",
            secondaryPrompt = "Watch now"
        ),
        VideoItem.Generic(
            id = 12,
            thumbnailUrl = getQualifiedImageUrl("wakanda_forever", VIDEO_STREAMING),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean(),
        )
    )
}