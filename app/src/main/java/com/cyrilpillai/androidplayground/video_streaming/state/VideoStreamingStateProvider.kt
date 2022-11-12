package com.cyrilpillai.androidplayground.video_streaming.state

import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.video_streaming.model.BottomNavItem
import com.cyrilpillai.androidplayground.video_streaming.ui.components.BottomBarState

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