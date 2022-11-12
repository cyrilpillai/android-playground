package com.cyrilpillai.androidplayground.video_streaming.model

import androidx.annotation.DrawableRes

data class BottomNavItem(
    val id: Int,
    val label: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val isSelected: Boolean
)