package com.cyrilpillai.androidplayground.video_streaming.state

import com.cyrilpillai.androidplayground.utils.ImageType
import com.cyrilpillai.androidplayground.utils.StorageBucket.VIDEO_STREAMING
import com.cyrilpillai.androidplayground.utils.getQualifiedImageUrl
import com.cyrilpillai.androidplayground.utils.getRandomColor
import com.cyrilpillai.androidplayground.video_streaming.model.DownloadItem
import com.cyrilpillai.androidplayground.video_streaming.model.FastLaughItem
import com.cyrilpillai.androidplayground.video_streaming.model.VideoItem
import com.cyrilpillai.androidplayground.video_streaming.ui.components.DownloadsScreenState
import com.cyrilpillai.androidplayground.video_streaming.ui.components.FastLaughsState
import com.cyrilpillai.androidplayground.video_streaming.ui.components.PromotionalVideoState
import com.cyrilpillai.androidplayground.video_streaming.ui.components.VideoCarouselState
import kotlin.random.Random

fun getDownloadsScreenState(): DownloadsScreenState {
    val videoItems = getVideoItems().shuffled().take(3)
    return DownloadsScreenState(
        downloadItem = DownloadItem(
            title = "Introducing Downloads for You",
            description = "We'll download a personalised selection of movies and shows for you, so there's always something to watch on your device.",
            primaryCta = "Set Up",
            secondaryCta = "See What You\n Can Download",
            primaryVideoItem = videoItems[0],
            secondaryStartVideoItem = videoItems[1],
            secondaryEndVideoItem = videoItems[2],
        )
    )
}

fun getPromotionalVideoState(): PromotionalVideoState {
    return PromotionalVideoState(
        videoItem = VideoItem.Promotional(
            id = 1,
            thumbnailUrl = getQualifiedImageUrl(
                relativeName = "brooklyn_nine_nine_promo",
                storageBucket = VIDEO_STREAMING
            ),
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

fun getFastLaughsState(): FastLaughsState {
    return FastLaughsState(
        listOf(
            FastLaughItem(
                id = 1,
                videoUrl = "Video 1",
                thumbnailUrl = getQualifiedImageUrl(
                    relativeName = "the_big_bang_theory",
                    storageBucket = VIDEO_STREAMING
                ),
                logoUrl = getQualifiedImageUrl(
                    relativeName = "the_big_bang_theory_logo",
                    storageBucket = VIDEO_STREAMING,
                    ImageType.PNG
                ),
                contentType = "U/A 13+",
                backgroundColor = getRandomColor()
            ),
            FastLaughItem(
                id = 2,
                videoUrl = "Video 2",
                thumbnailUrl = getQualifiedImageUrl(
                    relativeName = "how_i_met_your_mother",
                    storageBucket = VIDEO_STREAMING
                ),
                logoUrl = getQualifiedImageUrl(
                    relativeName = "how_i_met_your_mother_logo",
                    storageBucket = VIDEO_STREAMING,
                    ImageType.PNG
                ),
                contentType = "A",
                backgroundColor = getRandomColor()
            ),
            FastLaughItem(
                id = 3,
                videoUrl = "Video 3",
                thumbnailUrl = getQualifiedImageUrl(
                    relativeName = "rick_and_morty",
                    storageBucket = VIDEO_STREAMING
                ),
                logoUrl = getQualifiedImageUrl(
                    relativeName = "rick_and_morty_logo",
                    storageBucket = VIDEO_STREAMING,
                    ImageType.PNG
                ),
                contentType = "U/A 16+",
                backgroundColor = getRandomColor()
            ),
            FastLaughItem(
                id = 4,
                videoUrl = "Video 4",
                thumbnailUrl = getQualifiedImageUrl(
                    relativeName = "seinfeld",
                    storageBucket = VIDEO_STREAMING
                ),
                logoUrl = getQualifiedImageUrl(
                    relativeName = "seinfeld_logo",
                    storageBucket = VIDEO_STREAMING,
                    ImageType.PNG
                ),
                contentType = "A",
                backgroundColor = getRandomColor()
            ),
            FastLaughItem(
                id = 5,
                videoUrl = "Video 5",
                thumbnailUrl = getQualifiedImageUrl(
                    relativeName = "parks_and_recreation",
                    storageBucket = VIDEO_STREAMING
                ),
                logoUrl = getQualifiedImageUrl(
                    relativeName = "parks_and_recreation_logo",
                    storageBucket = VIDEO_STREAMING,
                    ImageType.PNG
                ),
                contentType = "U/A 13+",
                backgroundColor = getRandomColor()
            ),
            FastLaughItem(
                id = 6,
                videoUrl = "Video 6",
                thumbnailUrl = getQualifiedImageUrl(
                    relativeName = "game_of_thrones",
                    storageBucket = VIDEO_STREAMING
                ),
                logoUrl = getQualifiedImageUrl(
                    relativeName = "game_of_thrones_logo",
                    storageBucket = VIDEO_STREAMING,
                    ImageType.PNG
                ),
                contentType = "U/A 16+",
                backgroundColor = getRandomColor()
            )
        )
    )
}

fun getVideoItems(): List<VideoItem.Generic> {
    return listOf(
        VideoItem.Generic(
            id = 1,
            thumbnailUrl = getQualifiedImageUrl(
                relativeName = "brooklyn_nine_nine",
                storageBucket = VIDEO_STREAMING
            ),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean(),
            primaryPrompt = "New episode",
            secondaryPrompt = "Watch now"
        ),
        VideoItem.Generic(
            id = 2,
            thumbnailUrl = getQualifiedImageUrl(
                relativeName = "game_of_thrones",
                storageBucket = VIDEO_STREAMING
            ),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean(),
            primaryPrompt = "New seasons"
        ),
        VideoItem.Generic(
            id = 3,
            thumbnailUrl = getQualifiedImageUrl(
                relativeName = "money_heist",
                storageBucket = VIDEO_STREAMING
            )
        ),
        VideoItem.Generic(
            id = 4,
            thumbnailUrl = getQualifiedImageUrl(
                relativeName = "how_i_met_your_mother",
                storageBucket = VIDEO_STREAMING
            ),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean(),
            primaryPrompt = "New seasons"
        ),
        VideoItem.Generic(
            id = 5,
            thumbnailUrl = getQualifiedImageUrl(
                relativeName = "mr_robot",
                storageBucket = VIDEO_STREAMING
            ),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean()
        ),
        VideoItem.Generic(
            id = 6,
            thumbnailUrl = getQualifiedImageUrl(
                relativeName = "parks_and_recreation",
                storageBucket = VIDEO_STREAMING
            ),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean(),
        ),
        VideoItem.Generic(
            id = 7,
            thumbnailUrl = getQualifiedImageUrl(
                relativeName = "rick_and_morty",
                storageBucket = VIDEO_STREAMING
            ),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean(),
            primaryPrompt = "New episode",
            secondaryPrompt = "Watch now"
        ),
        VideoItem.Generic(
            id = 8,
            thumbnailUrl = getQualifiedImageUrl(
                relativeName = "seinfeld",
                storageBucket = VIDEO_STREAMING
            ),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean(),
            primaryPrompt = "New seasons",
            secondaryPrompt = "Watch now"
        ),
        VideoItem.Generic(
            id = 9,
            thumbnailUrl = getQualifiedImageUrl(
                relativeName = "squid_game",
                storageBucket = VIDEO_STREAMING
            )
        ),
        VideoItem.Generic(
            id = 10,
            thumbnailUrl = getQualifiedImageUrl(
                relativeName = "the_big_bang_theory",
                storageBucket = VIDEO_STREAMING
            ),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean(),
            primaryPrompt = "New seasons"
        ),
        VideoItem.Generic(
            id = 11,
            thumbnailUrl = getQualifiedImageUrl(
                relativeName = "the_good_place",
                storageBucket = VIDEO_STREAMING
            ),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean(),
            primaryPrompt = "New episode",
            secondaryPrompt = "Watch now"
        ),
        VideoItem.Generic(
            id = 12,
            thumbnailUrl = getQualifiedImageUrl(
                relativeName = "wakanda_forever",
                storageBucket = VIDEO_STREAMING
            ),
            isNetflixOriginal = Random.nextBoolean(),
            isTopTen = Random.nextBoolean(),
        )
    )
}