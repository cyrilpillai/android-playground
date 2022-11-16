package com.cyrilpillai.androidplayground.video_streaming.state

import com.cyrilpillai.androidplayground.utils.ImageType
import com.cyrilpillai.androidplayground.utils.StorageBucket.VIDEO_STREAMING
import com.cyrilpillai.androidplayground.utils.getQualifiedImageUrl
import com.cyrilpillai.androidplayground.utils.getRandomColor
import com.cyrilpillai.androidplayground.video_streaming.model.DownloadItem
import com.cyrilpillai.androidplayground.video_streaming.model.FastLaughItem
import com.cyrilpillai.androidplayground.video_streaming.model.NewAndHotItem
import com.cyrilpillai.androidplayground.video_streaming.model.NewAndHotType
import com.cyrilpillai.androidplayground.video_streaming.model.VideoItem
import com.cyrilpillai.androidplayground.video_streaming.ui.components.DownloadsScreenState
import com.cyrilpillai.androidplayground.video_streaming.ui.components.FastLaughsState
import com.cyrilpillai.androidplayground.video_streaming.ui.components.NewAndHotState
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
        fastLaughs = getFastLaughItems()
    )
}

fun getNewAndHotContentState(): NewAndHotState {
    return NewAndHotState(
        newAndHotList = getNewAndHotItems(NewAndHotType.COMING_SOON).shuffled() +
                getNewAndHotItems(NewAndHotType.EVERYONE_WATCHING).shuffled() +
                getNewAndHotItems(NewAndHotType.TOP_10_TV_SHOWS).shuffled() +
                getNewAndHotItems(NewAndHotType.TOP_10_MOVIES).shuffled()
    )
}

private fun getFastLaughItems(): List<FastLaughItem> {
    return listOf(
        FastLaughItem(
            id = 1,
            videoUrl = "Video 1",
            thumbnailUrl = getQualifiedImageUrl(
                relativeName = "mr_robot",
                storageBucket = VIDEO_STREAMING
            ),
            logoUrl = getQualifiedImageUrl(
                relativeName = "mr_robot_logo",
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
                relativeName = "money_heist",
                storageBucket = VIDEO_STREAMING
            ),
            logoUrl = getQualifiedImageUrl(
                relativeName = "money_heist_logo",
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
}

private fun getNewAndHotItems(type: NewAndHotType): List<NewAndHotItem> {
    val prefixId = when (type) {
        NewAndHotType.COMING_SOON -> 10
        NewAndHotType.EVERYONE_WATCHING -> 20
        NewAndHotType.TOP_10_TV_SHOWS -> 30
        NewAndHotType.TOP_10_MOVIES -> 40
    }
    return listOf(
        NewAndHotItem(
            id = prefixId + 1,
            type = type,
            name = "Mr Robot",
            description = "Elliot, a brilliant but highly unstable young cyber-security engineer and vigilante hacker, becomes a key figure in a complex game of global dominance when he and his shadowy allies try to take down the corrupt corporation he works for.",
            subtitle = "Seasons coming on 15 December",
            videoUrl = "Video 1",
            logoUrl = getQualifiedImageUrl(
                relativeName = "mr_robot_logo",
                storageBucket = VIDEO_STREAMING,
                ImageType.PNG
            ),
            stickyText = "DEC 01",
            contentType = "U/A 16+",
            isNetflixOriginal = true,
            backgroundColor = getRandomColor()
        ),
        NewAndHotItem(
            id = prefixId + 2,
            type = type,
            name = "Game of Thrones",
            description = "Nine noble families wage war against each other in order to gain control over the mythical land of Westeros. Meanwhile, a force is rising after millenniums and threatens the existence of living men.",
            videoUrl = "Video 2",
            logoUrl = getQualifiedImageUrl(
                relativeName = "game_of_thrones_logo",
                storageBucket = VIDEO_STREAMING,
                ImageType.PNG
            ),
            contentType = "U/A 16+",
            isNetflixOriginal = false,
            backgroundColor = getRandomColor()
        ),
        NewAndHotItem(
            id = prefixId + 3,
            type = type,
            name = "Money Heist",
            description = "A criminal mastermind who goes by \"The Professor\" has a plan to pull off the biggest heist in recorded history -- to print billions of euros in the Royal Mint of Spain.",
            subtitle = "Coming soon",
            videoUrl = "Video 3",
            logoUrl = getQualifiedImageUrl(
                relativeName = "money_heist_logo",
                storageBucket = VIDEO_STREAMING,
                ImageType.PNG
            ),
            stickyText = "DEC 06",
            contentType = "U/A 16+",
            isNetflixOriginal = true,
            backgroundColor = getRandomColor()
        ),
        NewAndHotItem(
            id = prefixId + 4,
            type = type,
            name = "Seinfeld",
            description = "Stand-up comedian Jerry Seinfeld wrestles with life's most perplexing yet trivial questions with his eccentric friends George, Elaine and Kramer.",
            videoUrl = "Video 4",
            logoUrl = getQualifiedImageUrl(
                relativeName = "seinfeld_logo",
                storageBucket = VIDEO_STREAMING,
                ImageType.PNG
            ),
            stickyText = "FEB 28",
            contentType = "A",
            isNetflixOriginal = true,
            backgroundColor = getRandomColor()
        ),
        NewAndHotItem(
            id = prefixId + 5,
            type = type,
            name = "Rick and Morty",
            description = "Rick, an alcoholic sociopath and scientist, lives with his daughter Beth's family. Apart from building gadgets, he takes his morally right but dimwit grandson Morty on absurd intergalactic adventures.",
            subtitle = "New episode on 21 November",
            videoUrl = "Video 5",
            logoUrl = getQualifiedImageUrl(
                relativeName = "rick_and_morty_logo",
                storageBucket = VIDEO_STREAMING,
                ImageType.PNG
            ),
            stickyText = "NOV 21",
            contentType = "U/A 16+",
            isNetflixOriginal = true,
            backgroundColor = getRandomColor()
        )
    )
}

private fun getVideoItems(): List<VideoItem.Generic> {
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