package com.cyrilpillai.androidplayground.social_media.model

import androidx.annotation.DrawableRes

data class BottomNavItem(
    val id: Int,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val isSelected: Boolean
)