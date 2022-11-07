package com.cyrilpillai.androidplayground.social_media.state

import androidx.compose.ui.graphics.Color
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.social_media.model.BottomNavItem
import com.cyrilpillai.androidplayground.social_media.model.CtaItem
import com.cyrilpillai.androidplayground.social_media.model.HighlightItem
import com.cyrilpillai.androidplayground.social_media.model.PostItem
import com.cyrilpillai.androidplayground.social_media.model.PostType
import com.cyrilpillai.androidplayground.social_media.model.TabItem
import com.cyrilpillai.androidplayground.social_media.ui.components.TopBarState
import com.cyrilpillai.androidplayground.social_media.ui.components.BottomBarState
import com.cyrilpillai.androidplayground.social_media.ui.components.CtaState
import com.cyrilpillai.androidplayground.social_media.ui.components.HighlightState
import com.cyrilpillai.androidplayground.social_media.ui.components.PostState
import com.cyrilpillai.androidplayground.social_media.ui.components.ProfileDetailsState
import com.cyrilpillai.androidplayground.social_media.ui.components.ProfileImageState
import com.cyrilpillai.androidplayground.social_media.ui.components.StatisticsState
import com.cyrilpillai.androidplayground.social_media.ui.components.TabsState


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
                selectedIcon = R.drawable.ic_search,
                unselectedIcon = R.drawable.ic_search,
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
        imageUrl = "https://cdn.myanimelist.net/r/360x360/images/characters/2/284121.jpg?s=5b0448ce14c283b38583b9ceaf86ae73"
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

fun getHighlightsState(): HighlightState {
    return HighlightState(
        listOf(
            HighlightItem(
                imageUrl = "https://i.pinimg.com/236x/9c/69/c8/9c69c804217c838adef752ee3cd60cd9.jpg",
                description = "Kurama"
            ),
            HighlightItem(
                imageUrl = "https://sites.google.com/site/wikyanime/_/rsrc/1468736796534/home/primera-temporada/the-exam-chunin/descarga%20%289%29.jpg?height=266&width=400",
                description = "Chunin Exams"
            ),
            HighlightItem(
                imageUrl = "https://qph.cf2.quoracdn.net/main-qimg-e58bccaca0d5861ebff576567a64e8e1-lq",
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
                imageUrl = "https://i.pinimg.com/736x/79/5b/53/795b5303feaf37283b0f07229a009150.jpg",
                postType = PostType.SINGLE_IMAGE
            ),
            PostItem(
                imageUrl = "https://occ-0-41-395.1.nflxso.net/dnm/api/v6/9pS1daC2n6UGc3dUogvWIPMR_OU/AAAABeDvcGkr2O4GMnBn0qBwNNSR_M0wGOcbyJ8J1hzlCpXKF_1JIxSUJjnsDMkc-f5ulXBPLynkyl5VgbvNHCkcx-BbJ-_Ls4ndYuU98kPZq9yhOZM9iWfyyHeR.jpg?r=43c",
                postType = PostType.MULTIPLE_IMAGES
            ),
            PostItem(
                imageUrl = "https://i.pinimg.com/originals/29/2a/f0/292af0f3389ac96039fdcc35d3726171.png",
                postType = PostType.SINGLE_IMAGE
            ),
            PostItem(
                imageUrl = "https://i.pinimg.com/originals/9b/e9/7c/9be97c78e019329b4055c55a9b4504b1.jpg",
                postType = PostType.VIDEO
            ),
            PostItem(
                imageUrl = "https://media.proprofs.com/images/QM/user_images/2503852/New%20Project%20(71)(6).jpg",
                postType = PostType.SINGLE_IMAGE
            ),
            PostItem(
                imageUrl = "https://i6.tagstat.com/p1/p/7HkgZgefrcnsHLZiyJ7bOVv9NQEWldblc4SwWPDwwVkG0IzvkaMHQypaqS3ItmBp.jpg",
                postType = PostType.SINGLE_IMAGE
            ),
            PostItem(
                imageUrl = "https://i.pinimg.com/736x/79/5b/53/795b5303feaf37283b0f07229a009150.jpg",
                postType = PostType.SINGLE_IMAGE
            ),
            PostItem(
                imageUrl = "https://occ-0-41-395.1.nflxso.net/dnm/api/v6/9pS1daC2n6UGc3dUogvWIPMR_OU/AAAABeDvcGkr2O4GMnBn0qBwNNSR_M0wGOcbyJ8J1hzlCpXKF_1JIxSUJjnsDMkc-f5ulXBPLynkyl5VgbvNHCkcx-BbJ-_Ls4ndYuU98kPZq9yhOZM9iWfyyHeR.jpg?r=43c",
                postType = PostType.MULTIPLE_IMAGES
            ),
            PostItem(
                imageUrl = "https://i.pinimg.com/originals/29/2a/f0/292af0f3389ac96039fdcc35d3726171.png",
                postType = PostType.SINGLE_IMAGE
            ),
            PostItem(
                imageUrl = "https://i.pinimg.com/originals/9b/e9/7c/9be97c78e019329b4055c55a9b4504b1.jpg",
                postType = PostType.VIDEO
            ),
            PostItem(
                imageUrl = "https://media.proprofs.com/images/QM/user_images/2503852/New%20Project%20(71)(6).jpg",
                postType = PostType.SINGLE_IMAGE
            ),
            PostItem(
                imageUrl = "https://i6.tagstat.com/p1/p/7HkgZgefrcnsHLZiyJ7bOVv9NQEWldblc4SwWPDwwVkG0IzvkaMHQypaqS3ItmBp.jpg",
                postType = PostType.SINGLE_IMAGE
            ),
            PostItem(
                imageUrl = "https://i.pinimg.com/736x/79/5b/53/795b5303feaf37283b0f07229a009150.jpg",
                postType = PostType.SINGLE_IMAGE
            ),
            PostItem(
                imageUrl = "https://occ-0-41-395.1.nflxso.net/dnm/api/v6/9pS1daC2n6UGc3dUogvWIPMR_OU/AAAABeDvcGkr2O4GMnBn0qBwNNSR_M0wGOcbyJ8J1hzlCpXKF_1JIxSUJjnsDMkc-f5ulXBPLynkyl5VgbvNHCkcx-BbJ-_Ls4ndYuU98kPZq9yhOZM9iWfyyHeR.jpg?r=43c",
                postType = PostType.MULTIPLE_IMAGES
            ),
            PostItem(
                imageUrl = "https://i.pinimg.com/originals/29/2a/f0/292af0f3389ac96039fdcc35d3726171.png",
                postType = PostType.SINGLE_IMAGE
            ),
            PostItem(
                imageUrl = "https://i.pinimg.com/originals/9b/e9/7c/9be97c78e019329b4055c55a9b4504b1.jpg",
                postType = PostType.VIDEO
            ),
            PostItem(
                imageUrl = "https://media.proprofs.com/images/QM/user_images/2503852/New%20Project%20(71)(6).jpg",
                postType = PostType.SINGLE_IMAGE
            ),
            PostItem(
                imageUrl = "https://i6.tagstat.com/p1/p/7HkgZgefrcnsHLZiyJ7bOVv9NQEWldblc4SwWPDwwVkG0IzvkaMHQypaqS3ItmBp.jpg",
                postType = PostType.SINGLE_IMAGE
            )
        )
    )
}
