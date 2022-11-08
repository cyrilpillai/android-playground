package com.cyrilpillai.androidplayground.social_media.state

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.F
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.StorageBucket.SOCIAL_MEDIA
import com.cyrilpillai.androidplayground.getQualifiedImageUrl
import com.cyrilpillai.androidplayground.social_media.model.BottomNavItem
import com.cyrilpillai.androidplayground.social_media.model.CtaItem
import com.cyrilpillai.androidplayground.social_media.model.FollowerItem
import com.cyrilpillai.androidplayground.social_media.model.HighlightItem
import com.cyrilpillai.androidplayground.social_media.model.PostItem
import com.cyrilpillai.androidplayground.social_media.model.PostType
import com.cyrilpillai.androidplayground.social_media.model.TabItem
import com.cyrilpillai.androidplayground.social_media.ui.components.BottomBarState
import com.cyrilpillai.androidplayground.social_media.ui.components.CtaState
import com.cyrilpillai.androidplayground.social_media.ui.components.FollowersState
import com.cyrilpillai.androidplayground.social_media.ui.components.HighlightState
import com.cyrilpillai.androidplayground.social_media.ui.components.PostState
import com.cyrilpillai.androidplayground.social_media.ui.components.ProfileDetailsState
import com.cyrilpillai.androidplayground.social_media.ui.components.ProfileImageState
import com.cyrilpillai.androidplayground.social_media.ui.components.StatisticsState
import com.cyrilpillai.androidplayground.social_media.ui.components.TabsState
import com.cyrilpillai.androidplayground.social_media.ui.components.TopBarState


fun getTopBarState(): TopBarState {
    return TopBarState("uzumaki.naruto")
}

fun getBottomBarState(): BottomBarState {
    return BottomBarState(
        listOf(
            BottomNavItem(
                id = 1,
                selectedIcon = R.drawable.ic_home_filled,
                unselectedIcon = R.drawable.ic_home_outline,
                isSelected = false
            ),
            BottomNavItem(
                id = 2,
                selectedIcon = R.drawable.ic_search_filled,
                unselectedIcon = R.drawable.ic_search_outline,
                isSelected = false
            ),
            BottomNavItem(
                id = 3,
                selectedIcon = R.drawable.ic_video_filled,
                unselectedIcon = R.drawable.ic_video_outlined,
                isSelected = false
            ),
            BottomNavItem(
                id = 4,
                selectedIcon = R.drawable.ic_favorite_filled,
                unselectedIcon = R.drawable.ic_favorite_outline,
                isSelected = false
            ),
            BottomNavItem(
                id = 5,
                selectedIcon = R.drawable.ic_account_circle_filled,
                unselectedIcon = R.drawable.ic_account_circle_outline,
                isSelected = true
            ),
        )
    )
}

fun getStatisticsState(): StatisticsState {
    return StatisticsState(
        posts = "100",
        followers = "8K",
        following = "5K"
    )
}

fun getProfileImageState(): ProfileImageState {
    return ProfileImageState(
        imageUrl = getQualifiedImageUrl("profile_photo", SOCIAL_MEDIA)
    )
}

fun getProfileDetailsState(): ProfileDetailsState {
    return ProfileDetailsState(
        name = "Uzumaki Naruto",
        bio = "\uD83C\uDF3F Konoha Shinobi\n\uD83E\uDD8A Kyūbi Jinchūriki\n7️⃣ Team 7 member\nI will become Hokage one day, dattebayo!",
        website = "naruto.com"
    )
}

fun getCtaState(): CtaState {
    return CtaState(
        listOf(
            CtaItem(
                text = "Following",
                icon = R.drawable.ic_expand_more,
                color = Color.Green
            ),
            CtaItem(
                text = "Message"
            ),
            CtaItem(
                icon = R.drawable.ic_add_person
            )
        )
    )
}

fun getFollowersState(): FollowersState {
    return FollowersState(
        listOf(
            FollowerItem(
                name = "uchiha.sasuke",
                imageUrl = getQualifiedImageUrl("follower_1", SOCIAL_MEDIA)
            ),
            FollowerItem(
                "haruno.sakura",
                imageUrl = getQualifiedImageUrl("follower_2", SOCIAL_MEDIA)
            ),
            FollowerItem(
                "hatake.kakashi",
                imageUrl = getQualifiedImageUrl("follower_3", SOCIAL_MEDIA)
            ),
            FollowerItem(
                "uchiha.itachi",
                imageUrl = getQualifiedImageUrl("follower_4", SOCIAL_MEDIA)
            ),
            FollowerItem(
                "nara.shikamaru",
                imageUrl = getQualifiedImageUrl("follower_5", SOCIAL_MEDIA)
            ),
        )
    )
}

fun getHighlightsState(): HighlightState {
    return HighlightState(
        listOf(
            HighlightItem(
                imageUrl = getQualifiedImageUrl("highlight_1", SOCIAL_MEDIA),
                description = "Kurama"
            ),
            HighlightItem(
                imageUrl = getQualifiedImageUrl("highlight_2", SOCIAL_MEDIA),
                description = "Chunin Exams"
            ),
            HighlightItem(
                imageUrl = getQualifiedImageUrl("highlight_3", SOCIAL_MEDIA),
                description = "Training"
            ),
            HighlightItem(
                imageUrl = getQualifiedImageUrl("highlight_1", SOCIAL_MEDIA),
                description = "Kurama"
            ),
            HighlightItem(
                imageUrl = getQualifiedImageUrl("highlight_2", SOCIAL_MEDIA),
                description = "Chunin Exams"
            ),
            HighlightItem(
                imageUrl = getQualifiedImageUrl("highlight_3", SOCIAL_MEDIA),
                description = "Training"
            ),
            HighlightItem(
                imageUrl = getQualifiedImageUrl("highlight_1", SOCIAL_MEDIA),
                description = "Kurama"
            ),
            HighlightItem(
                imageUrl = getQualifiedImageUrl("highlight_2", SOCIAL_MEDIA),
                description = "Chunin Exams"
            ),
            HighlightItem(
                imageUrl = getQualifiedImageUrl("highlight_3", SOCIAL_MEDIA),
                description = "Training"
            )
        )
    )
}

fun getTabsState(): TabsState {
    return TabsState(
        listOf(
            TabItem(
                position = 0,
                isSelected = true,
                icon = R.drawable.ic_grid,
                contentDescription = "posts"
            ),
            TabItem(
                position = 1,
                isSelected = false,
                icon = R.drawable.ic_video_filled,
                contentDescription = "reels"
            ),
            TabItem(
                position = 2,
                isSelected = false,
                icon = R.drawable.ic_account_square,
                contentDescription = "tagged"
            )
        )
    )
}

fun getPostsState(): PostState {
    return PostState(
        posts = listOf(
            PostItem(
                imageUrl = getQualifiedImageUrl("post_1", SOCIAL_MEDIA),
                postType = PostType.SINGLE_IMAGE
            ),
            PostItem(
                imageUrl = getQualifiedImageUrl("post_2", SOCIAL_MEDIA),
                postType = PostType.MULTIPLE_IMAGES
            ),
            PostItem(
                imageUrl = getQualifiedImageUrl("post_3", SOCIAL_MEDIA),
                postType = PostType.SINGLE_IMAGE
            ),
            PostItem(
                imageUrl = getQualifiedImageUrl("post_4", SOCIAL_MEDIA),
                postType = PostType.VIDEO
            ),
            PostItem(
                imageUrl = getQualifiedImageUrl("post_5", SOCIAL_MEDIA),
                postType = PostType.SINGLE_IMAGE
            ),
            PostItem(
                imageUrl = getQualifiedImageUrl("post_6", SOCIAL_MEDIA),
                postType = PostType.SINGLE_IMAGE
            ),
            PostItem(
                imageUrl = getQualifiedImageUrl("post_1", SOCIAL_MEDIA),
                postType = PostType.SINGLE_IMAGE
            ),
            PostItem(
                imageUrl = getQualifiedImageUrl("post_2", SOCIAL_MEDIA),
                postType = PostType.MULTIPLE_IMAGES
            ),
            PostItem(
                imageUrl = getQualifiedImageUrl("post_3", SOCIAL_MEDIA),
                postType = PostType.SINGLE_IMAGE
            ),
            PostItem(
                imageUrl = getQualifiedImageUrl("post_4", SOCIAL_MEDIA),
                postType = PostType.VIDEO
            ),
            PostItem(
                imageUrl = getQualifiedImageUrl("post_5", SOCIAL_MEDIA),
                postType = PostType.SINGLE_IMAGE
            ),
            PostItem(
                imageUrl = getQualifiedImageUrl("post_6", SOCIAL_MEDIA),
                postType = PostType.SINGLE_IMAGE
            )
        )
    )
}
