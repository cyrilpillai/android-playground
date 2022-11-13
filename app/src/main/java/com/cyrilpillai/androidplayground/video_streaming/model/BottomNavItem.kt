package com.cyrilpillai.androidplayground.video_streaming.model

import androidx.annotation.DrawableRes
import com.cyrilpillai.androidplayground.R

sealed class BottomNavItem(
    val title: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val screenRoute: String
) {
    object Home : BottomNavItem(
        title = "Home",
        selectedIcon = R.drawable.ic_home_filled,
        unselectedIcon = R.drawable.ic_home_outlined,
        screenRoute = "home"
    )

    object NewAndHot : BottomNavItem(
        title = "New & Hot",
        selectedIcon = R.drawable.ic_video_library_filled,
        unselectedIcon = R.drawable.ic_video_library_outlined,
        screenRoute = "new_and_hot"
    )

    object FastLaughs : BottomNavItem(
        title = "Fast Laughs",
        selectedIcon = R.drawable.ic_smiley_filled,
        unselectedIcon = R.drawable.ic_smiley_outlined,
        screenRoute = "fast_laughs"
    )

    object Downloads : BottomNavItem(
        title = "Downloads",
        selectedIcon = R.drawable.ic_download_filled,
        unselectedIcon = R.drawable.ic_download_outlined,
        screenRoute = "downloads"
    )
}