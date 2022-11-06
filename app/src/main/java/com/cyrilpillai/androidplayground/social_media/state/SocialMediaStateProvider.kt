package com.cyrilpillai.androidplayground.social_media.state

import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.social_media.model.BottomNavItem
import com.cyrilpillai.androidplayground.social_media.ui.components.AccountBarState
import com.cyrilpillai.androidplayground.social_media.ui.components.BottomBarState
import com.cyrilpillai.androidplayground.social_media.ui.components.EditProfileState
import com.cyrilpillai.androidplayground.social_media.ui.components.ProfileDetailsState
import com.cyrilpillai.androidplayground.social_media.ui.components.ProfileImageState
import com.cyrilpillai.androidplayground.social_media.ui.components.StatisticsState


fun getAccountBarState(): AccountBarState {
    return AccountBarState("uzumaki.naruto")
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
                icon = R.drawable.ic_video_player,
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
        bio = "Shinobi / Kyūbi Jinchūriki / Team 7 member\nI will become Hokage one day, dattebayo!",
        website = "naruto.com"
    )
}

fun getEditProfileState(): EditProfileState {
    return EditProfileState(
        cta = "Edit Profile"
    )
}