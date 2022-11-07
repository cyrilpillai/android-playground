package com.cyrilpillai.androidplayground.social_media.state

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.social_media.model.BottomNavItem
import com.cyrilpillai.androidplayground.social_media.model.CtaItem
import com.cyrilpillai.androidplayground.social_media.model.PostItem
import com.cyrilpillai.androidplayground.social_media.model.PostType
import com.cyrilpillai.androidplayground.social_media.ui.components.TopBarState
import com.cyrilpillai.androidplayground.social_media.ui.components.BottomBarState
import com.cyrilpillai.androidplayground.social_media.ui.components.CtaState
import com.cyrilpillai.androidplayground.social_media.ui.components.PostState
import com.cyrilpillai.androidplayground.social_media.ui.components.ProfileDetailsState
import com.cyrilpillai.androidplayground.social_media.ui.components.ProfileImageState
import com.cyrilpillai.androidplayground.social_media.ui.components.StatisticsState


fun getAccountBarState(): TopBarState {
    return TopBarState("uzumaki.naruto")
}

fun getBottomBarState(): BottomBarState {
    return BottomBarState(
        listOf(
            BottomNavItem(
                label = "Home",
                icon = R.drawable.ic_home,
                isSelected = false
            ),
            BottomNavItem(
                label = "Search",
                icon = R.drawable.ic_search,
                isSelected = false
            ),
            BottomNavItem(
                label = "Reels",
                icon = R.drawable.ic_video_outlined,
                isSelected = false
            ),
            BottomNavItem(
                label = "Liked",
                icon = R.drawable.ic_favorite_unselected,
                isSelected = false
            ),
            BottomNavItem(
                label = "Account",
                icon = R.drawable.ic_account_circle,
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

fun getEditProfileState(): CtaState {
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
